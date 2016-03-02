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
     * 插入item信息
     * @param item
     */
    boolean insertInfoGaterItem(InfoGaterItem item);

    /**
     * 通过projectId读取工程信息
     * @param projectId
     */
    List<InfoGaterItem> obtainInfoGaterItemsByProjectId(int projectId);
}
