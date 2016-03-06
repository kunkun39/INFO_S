package com.changhong.common.service.assember;

import com.changhong.common.domain.InfoGaterProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 10:19
 */
public class ProjectWebAssember {
    public static InfoGaterProject toProjectDomain(Map<String, Object> model) {
        InfoGaterProject project = null;

        if (model != null) {
            project = new InfoGaterProject();
            if (model.containsKey(InfoGaterProject.ID)) {
                project.setId((Integer) model.get(InfoGaterProject.ID));
            }

            if (model.containsKey(InfoGaterProject.USER_ID)) {
                project.setUserId((Integer) model.get(InfoGaterProject.USER_ID));
            }

            if (model.containsKey(InfoGaterProject.PROJECT_KEY)) {
                project.setProjectKey((String) model.get(InfoGaterProject.PROJECT_KEY));
            }

            if (model.containsKey(InfoGaterProject.PROJECT_NAME)) {
                project.setProjectName((String) model.get(InfoGaterProject.PROJECT_NAME));
            }
        }

        return project;
    }

    public static List<InfoGaterProject> toProjectDomainList(List<Map<String, Object>> models) {
        List<InfoGaterProject> projects = new ArrayList<InfoGaterProject>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                projects.add(toProjectDomain(model));
            }
        }

        return projects;
    }
}
