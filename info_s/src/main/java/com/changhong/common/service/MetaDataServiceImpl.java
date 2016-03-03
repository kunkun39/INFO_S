package com.changhong.common.service;

import com.changhong.common.domain.MetaData;
import com.changhong.common.facade.assember.MetaDataWebAssember;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.repository.MetaDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        MetaData metaData = MetaDataWebAssember.toAdminUserDomain(dto);

        return metaDataDao.insertMetaData(metaData);
    }

    @Override
    public int updateMetaData(MetaDataDTO dto) {
        MetaData metaData = MetaDataWebAssember.toAdminUserDomain(dto);

        return metaDataDao.updateMetaData(metaData);
    }

    @Override
    public int updateDetaDataStatus(int id, boolean isUsed) {
        return metaDataDao.updateMetaDataStatus(id, isUsed);
    }
}
