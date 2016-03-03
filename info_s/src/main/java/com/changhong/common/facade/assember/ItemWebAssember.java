package com.changhong.common.facade.assember;

import com.changhong.common.domain.InfoGaterItem;
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
    public static InfoGaterItemDTO toConfigDTO(Map<String, Object> model) {
        InfoGaterItemDTO dto = null;

        if (model != null) {
            dto = new InfoGaterItemDTO();
            if (model.containsKey(InfoGaterItem.ID)) {
                dto.setId((Integer) model.get(InfoGaterItem.ID));
            }

            if (model.containsKey(InfoGaterItem.ITEM_KEY)) {
                dto.setItemKey((String) model.get(InfoGaterItem.ITEM_KEY));
            }

            if (model.containsKey(InfoGaterItem.ITEM_NAME)) {
                dto.setItemName((String) model.get(InfoGaterItem.ITEM_NAME));
            }

            if (model.containsKey(InfoGaterItem.PROJECT_ID)) {
                dto.setProjectId((Integer) model.get(InfoGaterItem.PROJECT_ID));
            }

            if (model.containsKey(InfoGaterItem.METADATA_ID)) {
                dto.setMetaDataId((Integer) model.get(InfoGaterItem.METADATA_ID));
            }

            if (model.containsKey(MetaData.METADATA_NAME)) {
                dto.setMetadataName((String) model.get(MetaData.METADATA_NAME));
            }

        }

        return dto;
    }

    public static List<InfoGaterItemDTO> toConfigDomainList(List<Map<String, Object>> models) {
        List<InfoGaterItemDTO> items = new ArrayList<InfoGaterItemDTO>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                items.add(toConfigDTO(model));
            }
        }

        return items;
    }
}
