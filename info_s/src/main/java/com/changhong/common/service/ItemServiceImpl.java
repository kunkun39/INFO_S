package com.changhong.common.service;

import com.changhong.common.domain.InfoGaterItem;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.repository.ItemDao;
import com.changhong.common.facade.assember.ItemWebAssember;
import com.changhong.common.repository.MetaDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 8:38
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private MetaDataDao metaDataDao;

    @Override
    public boolean insertInfoGaterItem(InfoGaterItem item) {
        if (item != null) {
            return itemDao.insertInfoGaterItem(item);
        }
        return false;
    }

    @Override
    public List<InfoGaterItemDTO> obtainInfoGaterItemsByProjectId(int projectId) {
        return ItemWebAssember.toItemDomainList(itemDao.loadInfoGaterItemByProjectId(projectId));
    }

    @Override
    public boolean updateInfoGaterItem(InfoGaterItem item) {
        if (itemDao.updateInfoGaterItemById(item) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInfoGaterItem(int itemId, int metadataId) {
        if (itemDao.deleteInfoGaterItemById(itemId) > 0) {
            if (metadataId > 0) {
                metaDataDao.updateMetaDataStatus(metadataId, false);
            }
            return true;
        }
        return false;
    }
}
