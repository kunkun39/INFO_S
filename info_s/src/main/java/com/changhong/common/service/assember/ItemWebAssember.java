package com.changhong.common.service.assember;

import com.changhong.common.domain.InfoGaterItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 11:31
 */
public class ItemWebAssember {
    public static InfoGaterItem toConfigDomain(Map<String, Object> model) {
        InfoGaterItem item = null;

        if (model != null) {
            item = new InfoGaterItem();
            if (model.containsKey(InfoGaterItem.ID)) {
                item.setId((Integer) model.get(InfoGaterItem.ID));
            }

            if (model.containsKey(InfoGaterItem.ITEM_KEY)) {
                item.setItemKey((String) model.get(InfoGaterItem.ITEM_KEY));
            }

            if (model.containsKey(InfoGaterItem.ITEM_NAME)) {
                item.setItemName((String) model.get(InfoGaterItem.ITEM_NAME));
            }

            if (model.containsKey(InfoGaterItem.PROJECT_ID)) {
                item.setProjectId((Integer) model.get(InfoGaterItem.PROJECT_ID));
            }

            if (model.containsKey(InfoGaterItem.METADATA_ID)) {
                item.setMetaDataId((Integer) model.get(InfoGaterItem.METADATA_ID));
            }

        }

        return item;
    }

    public static List<InfoGaterItem> toConfigDomainList(List<Map<String, Object>> models) {
        List<InfoGaterItem> items = new ArrayList<InfoGaterItem>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                items.add(toConfigDomain(model));
            }
        }

        return items;
    }
}
