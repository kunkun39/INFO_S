package com.changhong.common.repository;

import com.changhong.common.domain.MetaData;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/2
 * Time: 10:13
 */
public interface MetaDataDao {

    /**
     * 向数据库表插入一个元数据信息
     * @param metaData
     */
    int insertMetaData(MetaData metaData);

    /**
     * 更新元数据信息
     * @param metaData
     */
    int updateMetaData(MetaData metaData);

    /**
     * 更新元数据状态信息
     * @param id
     * @param isUsed
     */
    int updateMetaDataStatus(int id, boolean isUsed);

    /**
     * 根据自己的ID号查找元数据项
     * @param metadataId
     * @param userId
     */
    List<Map<String, Object>> loadMetaDataBySelfId(int metadataId, int userId);

    /**
     * 根据userId查找元数据项
     * @param userId
     */
    List<Map<String, Object>> loadMetaDataByUserId(int userId);

    /**
     * 根据userId和projectId查找元数据项
     * @param userId
     * @param projectId
     */
    List<Map<String, Object>> loadMetaDataByIds(int userId, int projectId);

    /**
     * 根据自己的ID号删除元数据项
     * @param metadataId
     * @param userId
     */
    int deletaMetadataBySelfId(int metadataId, int userId);
}
