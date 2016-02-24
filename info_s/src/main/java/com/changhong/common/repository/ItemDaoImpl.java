package com.changhong.common.repository;

import com.changhong.common.domain.InfoGaterItem;
import com.changhong.mysql.BasicIbatisDataManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 15:17
 */
public class ItemDaoImpl extends BasicIbatisDataManager implements ItemDao {
    @Override
    public boolean insertInfoGaterItem(InfoGaterItem item) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterItem.ITEM_KEY, item.getItemKey());
        parameters.put(InfoGaterItem.ITEM_NAME, item.getItemName());
        parameters.put(InfoGaterItem.PROJECT_ID, item.getProjectId());
        parameters.put(InfoGaterItem.ITEM_CONTENT, item.getItemContent());

        Integer id = (Integer) getSqlMapClientTemplate().insert("Item.insertItem", parameters);
        if (id != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> loadInfoGaterItemByProjectId(int projectId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterItem.PROJECT_ID, projectId);
        return getSqlMapClientTemplate().queryForList("Item.selectItemByProjectId", parameters);
    }

    @Override
    public int updateInfoGaterItem(InfoGaterItem item, boolean updateName, boolean updateContent) {
        int effectId = -1;
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterItem.PROJECT_ID, item.getProjectId());
        if (updateName && updateContent) {
            parameters.put(InfoGaterItem.ITEM_NAME, item.getItemName());
            parameters.put(InfoGaterItem.ITEM_CONTENT, item.getItemContent());

            effectId = getSqlMapClientTemplate().update("Item.updateItemNameAndContent", parameters);
        } else if (updateName) {
            parameters.put(InfoGaterItem.ITEM_NAME, item.getItemName());

            effectId = getSqlMapClientTemplate().update("Item.updateItemName", parameters);
        } else if (updateContent) {
            parameters.put(InfoGaterItem.ITEM_CONTENT, item.getItemContent());

            effectId = getSqlMapClientTemplate().update("Item.updateItemContent", parameters);
        }

        return effectId;
    }
}
