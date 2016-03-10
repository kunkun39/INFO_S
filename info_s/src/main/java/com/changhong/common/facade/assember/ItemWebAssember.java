package com.changhong.common.facade.assember;

import com.changhong.common.domain.InfoGatherItem;
import com.changhong.common.domain.MetaData;
import com.changhong.common.facade.dto.InfoGaterItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 11:31
 */
public class ItemWebAssember {
    public static InfoGaterItemDTO toItemDomain(Map<String, Object> model) {
        InfoGaterItemDTO dto = null;

        if (model != null) {
            dto = new InfoGaterItemDTO();
            if (model.containsKey(InfoGatherItem.ID)) {
                dto.setId((Integer) model.get(InfoGatherItem.ID));
            }

            if (model.containsKey(InfoGatherItem.ITEM_KEY)) {
                dto.setItemKey((String) model.get(InfoGatherItem.ITEM_KEY));
            }

            if (model.containsKey(InfoGatherItem.ITEM_NAME)) {
                dto.setItemName((String) model.get(InfoGatherItem.ITEM_NAME));
            }

            if (model.containsKey(InfoGatherItem.PROJECT_ID)) {
                dto.setProjectId((Integer) model.get(InfoGatherItem.PROJECT_ID));
            }

            if (model.containsKey(InfoGatherItem.METADATA_ID)) {
                dto.setMetaDataId((Integer) model.get(InfoGatherItem.METADATA_ID));
            }

            if (model.containsKey(MetaData.METADATA_NAME)) {
                dto.setMetadataName((String) model.get(MetaData.METADATA_NAME));
            }

        }

        return dto;
    }

    public static List<InfoGaterItemDTO> toItemDomainList(List<Map<String, Object>> models) {
        List<InfoGaterItemDTO> items = new ArrayList<InfoGaterItemDTO>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                items.add(toItemDomain(model));
            }
        }

        return items;
    }
}
