package com.changhong.common.service;

import com.changhong.common.domain.InfoGatherProject;
import com.changhong.common.repository.ItemDao;
import com.changhong.common.repository.ProjectDao;
import com.changhong.common.facade.assember.ProjectWebAssember;
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
    public int insertInfoGatherProject(InfoGatherProject project) {
        if (project != null) {
            return projectDao.insertInfoGatherProject(project);
        }
        return -1;
    }

    @Override
    public InfoGatherProject obtainInfoGatherProjectByIds(int projectId, int userId) {
        List<Map<String, Object>> list =  projectDao.loadInfoGatherProjectByIds(projectId, userId);
        if (CHListUtils.hasElement(list)) {
            return ProjectWebAssember.toProjectDomain(list.get(0));
    }
    return null;
}

    @Override
    public List<InfoGatherProject> obtainInfoGatherProjectsByUserId(int userId) {
        return ProjectWebAssember.toProjectDomainList(projectDao.loadInfoGatherProjectByUserId(userId));
    }

    @Override
    public int obtainProjectIdByRandomKey(String randomKey) {
        List<Map<String, Object>> list = projectDao.loadInfoGatherProjectByRandomKey(randomKey);
        if (CHListUtils.hasElement(list)) {
            return ProjectWebAssember.toProjectDomain(list.get(0)).getId();
        }
        return -1;
    }

    @Override
    public boolean updateInfoGaterProject(InfoGatherProject project) {
        if (projectDao.updateInfoGatherProject(project) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInfoGatherProject(int projectId, int userId) {
        int test = projectDao.deleteInfoGatherProjectByIds(projectId, userId);
        if (test > 0) {
            itemDao.deleteInfoGatherItemByProjectId(projectId);
            return true;
        }
        return false;
    }
}
