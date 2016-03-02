package com.changhong.common.service;

import com.changhong.common.domain.InfoGaterProject;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 10:10
 */
public interface ProjectService {

    /**
     * ����project��Ϣ
     * @param project
     */
    int insertInfoGaterProject(InfoGaterProject project);

    /**
     * ͨ����Ŀid��ȡ������Ϣ
     * @param projectId
     * @param userId
     */
    InfoGaterProject obtainInfoGaterProjectByIds(int projectId, int userId);

    /**
     * ͨ��userId��ȡ������Ϣ
     * @param userId
     */
    List<InfoGaterProject> obtainInfoGaterProjectsByUserId(int userId);
}
