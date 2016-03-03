package com.changhong.common.service;

import com.changhong.common.facade.dto.MetaDataDTO;

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
     * @param isUsed
     */
    int updateDetaDataStatus(int id, boolean isUsed);

}
