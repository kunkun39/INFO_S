package com.changhong.common.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.changhong.common.domain.BasicData;
import com.changhong.common.domain.InfoGatherProject;
import com.changhong.common.facade.assember.ItemWebAssember;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.repository.ItemDao;
import com.changhong.common.repository.ProjectDao;
import com.changhong.common.facade.assember.ProjectWebAssember;
import com.changhong.common.utils.CHListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public String obtainProjectJsonFormat(int projectId, int userId) {
        JSONObject value = null;
        InfoGatherProject project = obtainInfoGatherProjectByIds(projectId, userId);
        if (project != null) {
            List<InfoGaterItemDTO> itemDTOList = ItemWebAssember.toItemDomainList(itemDao.loadInfoGatherItemByProjectId(projectId));
            if (CHListUtils.hasElement(itemDTOList)) {
                value = new JSONObject(true);
                value.put(BasicData.PROJECT_CODE, project.getProjectKey());

                for (String basicData : BasicData.getBasicDataList()) {
                    value.put(basicData, "value");
                }

                for (InfoGaterItemDTO dto : itemDTOList) {
                    value.put(dto.getItemKey(), "value");
                }
            }
        }
        if (value != null) {
            Set<String> set = value.keySet();
            value.DEFAULT_GENERATE_FEATURE = value.DEFAULT_GENERATE_FEATURE & (~SerializerFeature.SortField.getMask());
            return value.toJSONString();
        }
        return null;
    }
}
