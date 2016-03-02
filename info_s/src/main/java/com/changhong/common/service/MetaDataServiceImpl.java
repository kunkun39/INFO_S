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
    public boolean insertMetaData(MetaDataDTO dto) {
        MetaData metaData = MetaDataWebAssember.toAdminUserDomain(dto);

        if (metaDataDao.insertMetaData(metaData) != -1) {
            return true;
        }
        return false;
    }
}
