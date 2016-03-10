package com.changhong.common.repository;

import com.changhong.common.domain.InfoGatherItem;
import com.changhong.mysql.BasicIbatisDataManager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 15:17
 */
@Repository("itemDao")
public class ItemDaoImpl extends BasicIbatisDataManager implements ItemDao {
    @Override
    public boolean insertInfoGatherItem(InfoGatherItem item) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherItem.ITEM_KEY, item.getItemKey());
        parameters.put(InfoGatherItem.ITEM_NAME, item.getItemName());
        parameters.put(InfoGatherItem.PROJECT_ID, item.getProjectId());
        parameters.put(InfoGatherItem.METADATA_ID, item.getMetaDataId());

        Integer id = (Integer) getSqlMapClientTemplate().insert("Item.insertItem", parameters);
        if (id != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> loadInfoGatherItemByProjectId(int projectId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherItem.PROJECT_ID, projectId);
        return getSqlMapClientTemplate().queryForList("Item.selectItemByProjectId", parameters);
    }

    @Override
    public int updateInfoGatherItemById(InfoGatherItem item) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherItem.ID, item.getId());
        parameters.put(InfoGatherItem.ITEM_NAME, item.getItemName());
        parameters.put(InfoGatherItem.ITEM_KEY, item.getItemKey());
        parameters.put(InfoGatherItem.METADATA_ID, item.getMetaDataId());

        return getSqlMapClientTemplate().update("Item.updateItemById", parameters);
    }

    @Override
    public int deleteInfoGatherItemById(int id) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherItem.ID, id);

        return getSqlMapClientTemplate().delete("Item.deleteItemById", parameters);
    }

    @Override
    public int deleteInfoGatherItemByProjectId(int projecctId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherItem.PROJECT_ID, projecctId);

        return getSqlMapClientTemplate().delete("Item.deleteItemByProjectId", parameters);
    }
}
