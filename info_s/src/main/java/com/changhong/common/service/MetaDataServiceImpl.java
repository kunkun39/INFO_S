package com.changhong.common.service;

import com.changhong.common.domain.MetaData;
import com.changhong.common.facade.assember.MetaDataWebAssember;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.repository.MetaDataDao;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/2
 * Time: 10:57
 */
@Service("metaDataService")
public class MetaDataServiceImpl implements MetaDataService {

    @Autowired
    private MetaDataDao metaDataDao;

    @Override
    public int insertMetaData(MetaDataDTO dto) {
        MetaData metaData = MetaDataWebAssember.toMetaDataDomain(dto);

        return metaDataDao.insertMetaData(metaData);
    }

    @Override
    public int updateMetaData(MetaDataDTO dto) {
        MetaData metaData = MetaDataWebAssember.toMetaDataDomain(dto);

        return metaDataDao.updateMetaData(metaData);
    }

    @Override
    public int updateDetaDataStatus(int id, boolean isUsed) {
        return metaDataDao.updateMetaDataStatus(id, isUsed);
    }

    @Override
    public MetaDataDTO obtainMetaDataBySelfId(int metadataId, int userId) {
        List<Map<String, Object>> list = metaDataDao.loadMetaDataBySelfId(metadataId, userId);
        if (CHListUtils.hasElement(list)) {
            return MetaDataWebAssember.toMetaDataDTO(list.get(0));
        }
        return null;
    }

    @Override
    public List<MetaDataDTO> obtainMetaDataByIds(int userId, int projectId) {
        List<Map<String, Object>> list = null;
        if (projectId > -1) {
            list = metaDataDao.loadMetaDataByIds(userId, projectId);
        } else {
            list = metaDataDao.loadMetaDataByUserId(userId);
        }
        return MetaDataWebAssember.toMetaDataDTOList(list);
    }

    @Override
    public boolean deletaMetadataBySelfId(int metadataId, int userId) {
        return metaDataDao.deletaMetadataBySelfId(metadataId, userId) > 0 ? true : false;
    }
}
