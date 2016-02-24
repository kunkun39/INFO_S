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
     * �����ݿ�����һ�����ռ�����Ϣ
     * @param item
     */
    boolean insertInfoGaterItem(InfoGaterItem item);

    /**
     * ͨ������id��ȡ�ռ�����Ϣ
     * @param projectId
     */
    List<Map<String, Object>> loadInfoGaterItemByProjectId(int projectId);

    /**
     * �����ռ�����Ϣ
     * @param item
     * @param updateName
     * @param updateContent
     */
    int updateInfoGaterItem(InfoGaterItem item, boolean updateName, boolean updateContent);
}
