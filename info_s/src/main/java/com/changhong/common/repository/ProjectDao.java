package com.changhong.common.repository;

import com.changhong.common.domain.InfoGatherProject;

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
    int insertInfoGatherProject(InfoGatherProject project);

    /**
     * 读取所有工程信息
     */
    List<Map<String, Object>> loadInfoGatherProject();

    /**
     * 通过用户id读取工程信息
     * @param userId
     */
    List<Map<String, Object>> loadInfoGatherProjectByUserId(int userId);

    /**
     * 通过项目id读取工程信息
     * @param projectId
     * @param userId
     */
    List<Map<String, Object>> loadInfoGatherProjectByIds(int projectId, int userId);

    /**
     * 通过项目随机key读取工程信息
     * @param randomKey
     */
    List<Map<String, Object>> loadInfoGatherProjectByRandomKey(String randomKey);

    /**
     * 更新用户的工程信息
     * @param project
     */
    int updateInfoGatherProject(InfoGatherProject project);

    /**
     * 根据工程ID和用户ID删除工程信息
     * @param projectId
     * @param userId
     */
    int deleteInfoGatherProjectByIds(int projectId, int userId);
}
