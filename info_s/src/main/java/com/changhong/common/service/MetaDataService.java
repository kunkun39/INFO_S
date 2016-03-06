package com.changhong.common.service;

import com.changhong.common.facade.dto.MetaDataDTO;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/2
 * Time: 10:10
 */
public interface MetaDataService {

    /**
     * 插入metadata信息
     * @param dto
     */
    int insertMetaData(MetaDataDTO dto);

    /**
     * 更新metadata信息
     * @param dto
     */
    int updateMetaData(MetaDataDTO dto);

    /**
     * 更新metadata状态信息
     * @param id
     * @param isUsed
     */
    int updateDetaDataStatus(int id, boolean isUsed);

    /**
     * 根据自己的ID号查找元数据项
     * @param metadataId
     * @param userId
     */
    MetaDataDTO obtainMetaDataBySelfId(int metadataId, int userId);

    /**
     * 根据userId和projectId查找元数据项
     * @param userId
     * @param projectId
     */
    List<MetaDataDTO> obtainMetaDataByIds(int userId, int projectId);

    /**
     * 根据自己的ID号删除元数据项
     * @param metadataId
     * @param userId
     */
    boolean deletaMetadataBySelfId(int metadataId, int userId);
}
