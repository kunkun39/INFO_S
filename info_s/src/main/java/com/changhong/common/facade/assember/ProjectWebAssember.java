package com.changhong.common.facade.assember;

import com.changhong.common.domain.InfoGatherProject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 10:19
 */
public class ProjectWebAssember {
    public static InfoGatherProject toProjectDomain(Map<String, Object> model) {
        InfoGatherProject project = null;

        if (model != null) {
            project = new InfoGatherProject();
            if (model.containsKey(InfoGatherProject.ID)) {
                project.setId((Integer) model.get(InfoGatherProject.ID));
            }

            if (model.containsKey(InfoGatherProject.TIME_STAMP)) {
                String timestamp = model.get(InfoGatherProject.TIME_STAMP).toString();
                int endIndex = timestamp.indexOf(".");
                if (endIndex > 0) {
                    timestamp = timestamp.substring(0, endIndex);
                }
                project.setTimestamp(timestamp);
            }

            if (model.containsKey(InfoGatherProject.USER_ID)) {
                project.setUserId((Integer) model.get(InfoGatherProject.USER_ID));
            }

            if (model.containsKey(InfoGatherProject.PROJECT_KEY)) {
                project.setProjectKey((String) model.get(InfoGatherProject.PROJECT_KEY));
            }

            if (model.containsKey(InfoGatherProject.PROJECT_NAME)) {
                project.setProjectName((String) model.get(InfoGatherProject.PROJECT_NAME));
            }
        }

        return project;
    }

    public static List<InfoGatherProject> toProjectDomainList(List<Map<String, Object>> models) {
        List<InfoGatherProject> projects = new ArrayList<InfoGatherProject>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                projects.add(toProjectDomain(model));
            }
        }

        return projects;
    }
}
