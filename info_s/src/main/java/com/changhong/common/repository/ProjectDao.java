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
     * 向数据库表插入一个新工程信息
     * @param project
     */
    int insertInfoGaterProject(InfoGaterProject project);

    /**
     * 读取所有工程信息
     */
    List<Map<String, Object>> loadInfoGaterProject();

    /**
     * 通过用户id读取工程信息
     * @param userId
     */
    List<Map<String, Object>> loadInfoGaterProjectByUserId(int userId);

    /**
     * 通过项目id读取工程信息
     * @param projectId
     */
    List<Map<String, Object>> loadInfoGaterProjectByIds(int projectId, int userId);

    /**
     * 更新用户的工程信息
     * @param project
     */
    int updateInfoGaterProject(InfoGaterProject project);
}
