package com.changhong.common.service;

import com.changhong.common.domain.InfoGatherItem;
import com.changhong.common.facade.dto.InfoGaterItemDTO;

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
    boolean insertInfoGaterItem(InfoGatherItem item);

    /**
     * 通过projectId读取工程信息
     * @param projectId
     */
    List<InfoGaterItemDTO> obtainInfoGaterItemsByProjectId(int projectId);

    /**
     * 更新item信息
     * @param item
     */
    boolean updateInfoGaterItem(InfoGatherItem item);

    /**
     * 删除收集项
     * @param itemId
     * @param metadataId
     */
    boolean deleteInfoGaterItem(int itemId, int metadataId);
}
