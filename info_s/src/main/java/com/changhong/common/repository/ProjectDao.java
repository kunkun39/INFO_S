package com.changhong.common.repository;

import com.changhong.common.domain.InfoGaterProject;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 11:23
 */
public interface ProjectDao {

    /**
     * �����ݿ�����һ���¹�����Ϣ
     * @param project
     */
    boolean insertInfoGaterProject(InfoGaterProject project);

    /**
     * ��ȡ���й�����Ϣ
     */
    List<Map<String, Object>> loadInfoGaterProject();

    /**
     * ͨ���û�id��ȡ������Ϣ
     * @param userId
     */
    List<Map<String, Object>> loadInfoGaterProjectByUserId(int userId);

    /**
     * �����û��Ĺ�����Ϣ
     * @param project
     */
    int updateInfoGaterProject(InfoGaterProject project);
}
