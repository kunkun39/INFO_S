package com.changhong.common.service;

import com.changhong.common.domain.InfoGaterItem;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 8:36
 */
public interface ItemService {

    /**
     * ����item��Ϣ
     * @param item
     */
    boolean insertInfoGaterItem(InfoGaterItem item);

    /**
     * ͨ��projectId��ȡ������Ϣ
     * @param projectId
     */
    List<InfoGaterItem> obtainInfoGaterItemsByProjectId(int projectId);
}
