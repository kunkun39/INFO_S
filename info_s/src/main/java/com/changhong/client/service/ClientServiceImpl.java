package com.changhong.client.service;

import com.alibaba.fastjson.JSONObject;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:46
 */
@Repository("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ItemService itemService;

    @Override
    public JSONObject obtainProjectFormat(String randomKey) {
        JSONObject object = null;
        int projectId = projectService.obtainProjectIdByRandomKey(randomKey);
        if (projectId != -1) {
            List<InfoGaterItemDTO> dtoList = itemService.obtainInfoGaterItemsByProjectId(projectId);
            if (CHListUtils.hasElement(dtoList)) {
                object = new JSONObject();
                object.put("ProjectName", randomKey);
                for (InfoGaterItemDTO dto : dtoList) {
                    object.put(dto.getItemKey(), "value");
                }
            }
        }
        return object;
    }
}
