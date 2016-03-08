package com.changhong.client.service;

import com.alibaba.fastjson.JSONObject;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int obtainProjectId(String randomKey) {
        return projectService.obtainProjectIdByRandomKey(randomKey);
    }

    @Override
    public String obtainProjectFormat(int projectId) {
        JSONObject object = null;
        if (projectId != -1) {
            List<InfoGaterItemDTO> dtoList = itemService.obtainInfoGaterItemsByProjectId(projectId);
            if (CHListUtils.hasElement(dtoList)) {
                object = new JSONObject();
                object.put("ProjectName", projectId);
                for (InfoGaterItemDTO dto : dtoList) {
                    object.put(dto.getItemKey(), "value");
                }
            }
        }
        return object.toString();
    }

    @Override
    public List<String> obtainInfogaterItemParam(int projectId) {
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
}
