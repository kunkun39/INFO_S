package com.changhong.common.facade.assember;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.changhong.common.domain.MetaData;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.facade.dto.MetaDataSubItem;
import com.changhong.common.utils.CHListUtils;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 20:55
 */
public class MetaDataWebAssember {
    public static MetaData toAdminUserDomain(MetaDataDTO dto) {
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
        values.put("content", all);
        return values.toString();
    }
}
