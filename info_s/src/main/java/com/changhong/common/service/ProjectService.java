package com.changhong.common.service;

import com.changhong.common.domain.InfoGatherProject;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 10:10
 */
public interface ProjectService {

    /**
     * 插入project信息
     * @param project
     */
    int insertInfoGatherProject(InfoGatherProject project);

    /**
     * 通过项目id读取工程信息
     * @param projectId
     * @param userId
     */
    InfoGatherProject obtainInfoGatherProjectByIds(int projectId, int userId);

    /**
     * 通过userId读取工程信息
     * @param userId
     */
    List<InfoGatherProject> obtainInfoGatherProjectsByUserId(int userId);

    /**
     * 通过项目的随机码取得该项目的ID号
     * @param randomKey
     */
    int obtainProjectIdByRandomKey(String randomKey);

    /**
     * 更新用户的工程信息
     * @param project
     */
    boolean updateInfoGaterProject(InfoGatherProject project);

    /**
     * 删除工程信息
     * @param projectId
     * @param userId
     */
    boolean deleteInfoGatherProject(int projectId, int userId);

}
