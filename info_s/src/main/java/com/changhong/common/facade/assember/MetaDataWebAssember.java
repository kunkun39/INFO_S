package com.changhong.common.facade.assember;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.changhong.common.domain.InfoGaterItem;
import com.changhong.common.domain.InfoGaterProject;
import com.changhong.common.domain.MetaData;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.facade.dto.MetaDataSubItem;
import com.changhong.common.utils.CHListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 20:55
 */
public class MetaDataWebAssember {
    public static MetaData toMetaDataDomain(MetaDataDTO dto) {
        MetaData metaData = null;

        if (dto != null) {
            metaData = new MetaData();
            metaData.setId(dto.getId());
            metaData.setMetadataName(dto.getMetadataName());
            metaData.setUserId(dto.getUserId());
            metaData.setProjectId(dto.getProjectId());
            metaData.setIsUsed(dto.isUsed());
            if (dto.isUsed()) {
                metaData.setContent(parseToJson(dto.getItems()));
            }
        }

        return metaData;
    }

    public static MetaDataDTO toMetaDataDTO (Map<String, Object> model) {
        MetaDataDTO dto = null;

        if (model != null) {
            dto = new MetaDataDTO();
            if (model.containsKey(MetaData.ID)) {
                dto.setId((Integer) model.get(MetaData.ID));
            }

            if (model.containsKey(MetaData.METADATA_NAME)) {
                dto.setMetadataName((String) model.get(MetaData.METADATA_NAME));
            }

            if (model.containsKey(MetaData.IS_USED)) {
                dto.setUsed(((Integer) model.get(MetaData.IS_USED)).intValue() > 0 ? true : false);
            }

            if (model.containsKey(MetaData.METADATA_CONTENT)) {
                dto.setItems(parseToList((String) model.get(MetaData.METADATA_CONTENT)));
            }

            if (model.containsKey(InfoGaterItem.ITEM_NAME)) {
                dto.setItemName((String) model.get(InfoGaterItem.ITEM_NAME));
            }

            if (model.containsKey(InfoGaterProject.PROJECT_NAME)) {
                dto.setProjectName((String) model.get(InfoGaterProject.PROJECT_NAME));
            }
        }
        return dto;
    }

    public static List<MetaDataDTO> toMetaDataDTOList(List<Map<String, Object>> models) {
        List<MetaDataDTO> items = new ArrayList<MetaDataDTO>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                items.add(toMetaDataDTO(model));
            }
        }

        return items;
    }

    private static String parseToJson (List<MetaDataSubItem> items) {
        if (!CHListUtils.hasElement(items)) {
            return null;
        }
        JSONArray all = new JSONArray();
        for (MetaDataSubItem item : items) {
            JSONObject obj = new JSONObject();
            obj.put(MetaDataSubItem.INDEX, item.getIndex());
            obj.put(MetaDataSubItem.VALUE, item.getValue());
            all.add(obj);
        }
        JSONObject values = new JSONObject();
        values.put(MetaDataSubItem.CONTENT, all);
        return values.toString();
    }

    private static List<MetaDataSubItem> parseToList (String metaDataContent) {
        JSONObject obj = JSON.parseObject(metaDataContent);
        List<MetaDataSubItem> list = null;
        if (obj != null) {
            JSONArray array = obj.getJSONArray(MetaDataSubItem.CONTENT);
            list = JSON.parseObject(array.toString(), new TypeReference<List<MetaDataSubItem>>(){});
        }
        return list;
    }
}
