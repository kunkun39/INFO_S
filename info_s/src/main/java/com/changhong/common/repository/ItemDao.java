package com.changhong.common.repository;

import com.changhong.common.domain.InfoGaterItem;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 15:09
 */
public interface ItemDao {

    /**
     * 向数据库表插入一个新收集项信息
     * @param item
     */
    boolean insertInfoGaterItem(InfoGaterItem item);

    /**
     * 通过工程id读取收集项信息
     * @param projectId
     */
    List<Map<String, Object>> loadInfoGaterItemByProjectId(int projectId);

    /**
     * 更新收集项信息
     * @param item
     */
    int updateInfoGaterItemById(InfoGaterItem item);

    /**
     * 根据收集项ID删除收集项
     * @param id
     */
    int deleteInfoGaterItemById(int id);

    /**
     * 根据工程ID删除收集项
     * @param projecctId
     */
    int deleteInfoGaterItemByProjectId(int projecctId);
}
