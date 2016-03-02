package com.changhong.common.service;

import com.changhong.common.domain.InfoGaterItem;
import com.changhong.common.repository.ItemDao;
import com.changhong.common.service.assember.ItemWebAssember;
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
    @Override
    public boolean insertInfoGaterItem(InfoGaterItem item) {
        if (item != null) {
            return itemDao.insertInfoGaterItem(item);
        }
        return false;
    }

    @Override
    public List<InfoGaterItem> obtainInfoGaterItemsByProjectId(int projectId) {
        return ItemWebAssember.toConfigDomainList(itemDao.loadInfoGaterItemByProjectId(projectId));
    }
}
