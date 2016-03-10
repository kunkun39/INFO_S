package com.changhong.common.repository;

import com.changhong.common.domain.InfoGatherProject;
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
    public int insertInfoGatherProject(InfoGatherProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.USER_ID, project.getUserId());
        parameters.put(InfoGatherProject.PROJECT_KEY, project.getProjectKey());
        parameters.put(InfoGatherProject.PROJECT_NAME, project.getProjectName());

        Integer id = (Integer) getSqlMapClientTemplate().insert("Project.insertProject", parameters);
        if (id != null) {
            return id;
        }
        return -1;
    }

    @Override
    public List<Map<String, Object>> loadInfoGatherProject() {
        return getSqlMapClientTemplate().queryForList("Project.selectAllProject");
    }

    @Override
    public List<Map<String, Object>> loadInfoGatherProjectByUserId(int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.USER_ID, userId);

        return getSqlMapClientTemplate().queryForList("Project.selectProjectByUserId", parameters);
    }

    @Override
    public List<Map<String, Object>> loadInfoGatherProjectByIds(int projectId, int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.ID, projectId);
        parameters.put(InfoGatherProject.USER_ID, userId);

        return getSqlMapClientTemplate().queryForList("Project.selectProjectByIds", parameters);
    }

    @Override
    public List<Map<String, Object>> loadInfoGatherProjectByRandomKey(String randomKey) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.PROJECT_KEY, randomKey);

        return getSqlMapClientTemplate().queryForList("Project.selectProjectIdByRandomkey", parameters);
    }

    @Override
    public int updateInfoGatherProject(InfoGatherProject project) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.ID, project.getId());
        parameters.put(InfoGatherProject.PROJECT_NAME, project.getProjectName());

        return getSqlMapClientTemplate().update("Project.updateProjectName", parameters);
    }

    @Override
    public int deleteInfoGatherProjectByIds(int projectId, int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put(InfoGatherProject.ID, projectId);
        parameters.put(InfoGatherProject.USER_ID, userId);

        return getSqlMapClientTemplate().delete("Project.deleteProjectByIds", parameters);
    }
}
