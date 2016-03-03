package com.changhong.common.repository;

import com.changhong.common.domain.InfoGaterProject;
import com.changhong.mysql.BasicIbatisDataManager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 11:59
 */
@Repository("projectDao")
public class ProjectDaoImpl extends BasicIbatisDataManager implements ProjectDao {
    @Override
    public int insertInfoGaterProject(InfoGaterProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.USER_ID, project.getUserId());
        parameters.put(InfoGaterProject.PROJECT_KEY, project.getProjectKey());
        parameters.put(InfoGaterProject.PROJECT_NAME, project.getProjectName());

        Integer id = (Integer) getSqlMapClientTemplate().insert("Project.insertProject", parameters);
        if (id != null) {
            return id;
        }
        return -1;
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
    public List<Map<String, Object>> loadInfoGaterProjectByIds(int projectId, int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.ID, projectId);
        parameters.put(InfoGaterProject.USER_ID, userId);

        return getSqlMapClientTemplate().queryForList("Project.selectProjectByIds", parameters);
    }

    @Override
    public int updateInfoGaterProject(InfoGaterProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGaterProject.ID, project.getId());
        parameters.put(InfoGaterProject.PROJECT_NAME, project.getProjectName());
        return getSqlMapClientTemplate().update("Project.updateProjectName", parameters);
    }
}
