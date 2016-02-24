package com.changhong.common.repository;

import com.changhong.common.domain.InfoGaterProject;
import com.changhong.mysql.BasicIbatisDataManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 11:59
 */
public class ProjectDaoImpl extends BasicIbatisDataManager implements ProjectDao {
    @Override
    public boolean insertInfoGaterProject(InfoGaterProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.USER_ID, project.getUserId());
        parameters.put(InfoGaterProject.PROJECT_KEY, project.getProjectKey());
        parameters.put(InfoGaterProject.PROJECT_NAME, project.getProjectName());

        Integer id = (Integer) getSqlMapClientTemplate().insert("Project.insertProject", parameters);
        if (id != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> loadInfoGaterProject() {
        return getSqlMapClientTemplate().queryForList("Project.selectAllProject");
    }

    @Override
    public List<Map<String, Object>> loadInfoGaterProjectByUserId(int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.USER_ID, userId);
        return getSqlMapClientTemplate().queryForList("Project.selectProjectByUserId", parameters);
    }

    @Override
    public int updateInfoGaterProject(InfoGaterProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.USER_ID, project.getUserId());
        parameters.put(InfoGaterProject.PROJECT_NAME, project.getProjectName());
        return getSqlMapClientTemplate().update("Project.updateProjectName", parameters);
    }
}
