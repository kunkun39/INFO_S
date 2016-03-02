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

    int insertMetaData(MetaData metaData);

    int updateMetaData(MetaData metaData);

    int updateMetaDataStatus(int id, boolean isUsed);

    List<Map<String, Object>> loadMetaDataByUserId(int userId);

    List<Map<String, Object>> loadMetaDataByIds(int userId, int projectId);
}
