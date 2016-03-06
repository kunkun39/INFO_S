package com.changhong.common.service;

import com.changhong.common.domain.InfoGaterProject;
import com.changhong.common.repository.ItemDao;
import com.changhong.common.repository.ProjectDao;
import com.changhong.common.service.assember.ProjectWebAssember;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 10:28
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public int insertInfoGaterProject(InfoGaterProject project) {
        if (project != null) {
            return projectDao.insertInfoGaterProject(project);
        }
        return -1;
    }

    @Override
    public InfoGaterProject obtainInfoGaterProjectByIds(int projectId, int userId) {
        List<Map<String, Object>> list =  projectDao.loadInfoGaterProjectByIds(projectId, userId);
        if (CHListUtils.hasElement(list)) {
            return ProjectWebAssember.toProjectDomain(list.get(0));
    }
    return null;
}

    @Override
    public List<InfoGaterProject> obtainInfoGaterProjectsByUserId(int userId) {
        return ProjectWebAssember.toProjectDomainList(projectDao.loadInfoGaterProjectByUserId(userId));
    }

    @Override
    public boolean updateInfoGaterProject(InfoGaterProject project) {
        if (projectDao.updateInfoGaterProject(project) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInfoGaterProject(int projectId, int userId) {
        int test = projectDao.deleteInfoGaterProjectByIds(projectId, userId);
        if (test > 0) {
            itemDao.deleteInfoGaterItemByProjectId(projectId);
            return true;
        }
        return false;
    }
}
