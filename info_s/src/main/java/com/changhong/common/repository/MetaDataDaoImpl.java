package com.changhong.common.repository;

import com.changhong.common.domain.MetaData;
import com.changhong.mysql.BasicIbatisDataManager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/2
 * Time: 10:42
 */
@Repository("metaDataDao")
public class MetaDataDaoImpl extends BasicIbatisDataManager implements MetaDataDao {
    @Override
    public int insertMetaData(MetaData metaData) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.METADATA_NAME, metaData.getMetadataName());
        parameters.put(MetaData.USER_ID, metaData.getUserId());
        parameters.put(MetaData.PROJECT_ID, metaData.getProjectId());
        parameters.put(MetaData.IS_USED, metaData.isUsed());
        parameters.put(MetaData.METADATA_CONTENT, metaData.getContent());

        Integer id = (Integer) getSqlMapClientTemplate().insert("MetaData.insertMetaData", parameters);
        if (id != null) {
            return id;
        }
        return -1;
    }

    @Override
    public int updateMetaData(MetaData metaData) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.ID, metaData.getId());
        parameters.put(MetaData.METADATA_NAME, metaData.getMetadataName());
        parameters.put(MetaData.METADATA_CONTENT, metaData.getContent());

        return getSqlMapClientTemplate().update("MetaData.updateMetaData", parameters);
    }

    @Override
    public int updateMetaDataStatus(int id, boolean isUsed) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.ID, id);
        parameters.put(MetaData.IS_USED, isUsed);

        return getSqlMapClientTemplate().update("MetaData.updateUsedInfo", parameters);
    }

    @Override
    public List<Map<String, Object>> loadMetaDataBySelfId(int metadataId, int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.ID, metadataId);
        parameters.put(MetaData.USER_ID, userId);

        return getSqlMapClientTemplate().queryForList("MetaData.selectMetaDataBySelfId", parameters);
    }

    @Override
    public List<Map<String, Object>> loadMetaDataByUserId(int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.USER_ID, userId);

        return getSqlMapClientTemplate().queryForList("MetaData.selectMetaDataByUserId", parameters);
    }

    @Override
    public List<Map<String, Object>> loadMetaDataByIds(int userId, int projectId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.USER_ID, userId);
        parameters.put(MetaData.PROJECT_ID, projectId);

        return getSqlMapClientTemplate().queryForList("MetaData.selectMetaDataByIds", parameters);
    }

    @Override
    public int deletaMetadataBySelfId(int metadataId, int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(MetaData.ID, metadataId);
        parameters.put(MetaData.USER_ID, userId);

        return getSqlMapClientTemplate().delete("MetaData.deleteMetaDataBySelfId", parameters);
    }
}
