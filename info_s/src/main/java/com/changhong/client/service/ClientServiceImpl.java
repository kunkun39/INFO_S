package com.changhong.client.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.changhong.client.domain.ResponseCode;
import com.changhong.common.domain.BasicData;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:46
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private DataProcessService dataProcessService;

    @Override
    public int obtainProjectId(String projectCode) {
        return projectService.obtainProjectIdByRandomKey(projectCode);
    }

    @Override
    public String obtainProjectFormat(String projectCode) {
        JSONObject value = new JSONObject();
        JSONObject object = null;
        if (StringUtils.hasText(projectCode)) {
            int projectId = obtainProjectId(projectCode);
            if (projectId != -1) {
                List<InfoGaterItemDTO> dtoList = itemService.obtainInfoGaterItemsByProjectId(projectId);
                if (CHListUtils.hasElement(dtoList)) {
                    object = new JSONObject();
                    object.put(BasicData.PROJECT_CODE, projectCode);
                    for (InfoGaterItemDTO dto : dtoList) {
                        object.put(dto.getItemKey(), "value");
                    }

                    for (String basicData : BasicData.getBasicDataList()) {
                        object.put(basicData, "value");
                    }
                }
            }
            if (object != null) {
                value.put("content", object);
                value.put("response", ResponseCode.SUCCESS.getCode());
            } else {
                value.put("response", ResponseCode.PROJECTNOTEXIST.getCode());
            }
        } else {
            value.put("response", ResponseCode.PARAMERROR.getCode());
        }

        return value.toJSONString();
    }

    @Override
    public List<String> obtainInfogatherItemList(int projectId) {
        List<String> list = null;
        if (projectId != -1) {
            List<InfoGaterItemDTO> dtoList = itemService.obtainInfoGaterItemsByProjectId(projectId);
            if (CHListUtils.hasElement(dtoList)) {
                list = new ArrayList<String>();
                for (InfoGaterItemDTO dto : dtoList) {
                    list.add(dto.getItemKey());
                }
            }
        }
        return list;
    }

    @Override
    public String processInfoData(String infoData) {
        /* 数据处理 */
        JSONObject obj = JSON.parseObject(infoData);
        List<Map<String,Object>> resultList = new ArrayList<Map<String, Object>>();
        if (obj != null) {
            JSONArray array = obj.getJSONArray("vaules");
            for (int i = 0; i < array.size(); i++) {
                JSONObject projectJson = array.getJSONObject(i);
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("id", i);

                Map<String,Object> dataMap = parseProjectData(projectJson, resultMap);
                if (dataMap != null) {
                    dataProcessService.insertData(dataMap);
                }
                resultList.add(resultMap);
            }
        } else {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("code", ResponseCode.PARAMERROR.getCode());
            resultList.add(resultMap);
        }

        /* 返回结果封装 */
        JSONArray resonseArray = new JSONArray();
        for (Map<String,Object> result : resultList) {
            JSONObject resonseObject = new JSONObject();
            for (String key : result.keySet()) {
                resonseObject.put(key, result.get(key));
            }
            resonseArray.add(resonseObject);
        }
        JSONObject result = new JSONObject();
        result.put("response", resonseArray);

        return result.toJSONString();
    }

    private Map<String,Object> parseProjectData(JSONObject obj, Map<String, Object> resultMap) {
        int projectId = -1;
        Map<String,Object> data = new HashMap<String, Object>();
        /* project code处理 */
        if (obj.containsKey(BasicData.PROJECT_CODE)) {
            projectId = obtainProjectId(obj.getString(BasicData.PROJECT_CODE));
            resultMap.put(BasicData.PROJECT_CODE, obj.getString(BasicData.PROJECT_CODE));
            if (projectId != -1) {
                data.put(BasicData.PROJECT_CODE, obj.getString(BasicData.PROJECT_CODE));
            } else {
                resultMap.put("code", ResponseCode.PROJECTNOTEXIST.getCode());
                return null;
            }
        } else {
            resultMap.put("code", ResponseCode.PROJECTCODEMISS.getCode());
            return null;
        }

        /* 基础数据处理 */
        List<String> basicDataList = BasicData.getBasicDataList();
        for (String basicData : basicDataList) {
            if (obj.containsKey(basicData)) {
                data.put(basicData, obj.getString(basicData));
            } else {
                resultMap.put("code", ResponseCode.BASICDATAMISS.getCode());
                return null;
            }
        }
        /* 收集项处理 */
        List<String> gatherItemList = obtainInfogatherItemList(projectId);
        for (String gatherItem : gatherItemList) {
            if (obj.containsKey(gatherItem)) {
                data.put(gatherItem, obj.getString(gatherItem));
            } else {
                resultMap.put("code", ResponseCode.FORMATERROR.getCode());
                return null;
            }
        }
        resultMap.put("code", ResponseCode.SUCCESS.getCode());
        return data;
    }
}
