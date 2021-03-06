package com.changhong.system.web.controller.projectmanager;

import com.changhong.common.domain.InfoGatherProject;
import com.changhong.common.facade.dto.InfoGaterItemDTO;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.SecurityUtils;
import com.changhong.system.property.MenuKeyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: pengjie
 * Date: 2016/2/26
 * Time: 9:37
 */
@Controller
@RequestMapping("/project/projectform.html")
public class ProjectFormController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(method= RequestMethod.GET)
    public String setUpForm(HttpServletRequest request, ModelMap model) {
        int projectId = ServletRequestUtils.getIntParameter(request, "projectId", -1);
        int userId = SecurityUtils.currectAuthenticationId();

        InfoGatherProject project = null;
        if (projectId > 0) {
            project = projectService.obtainInfoGatherProjectByIds(projectId, userId);
        }
        if (project == null) {
            project = new InfoGatherProject();
            model.put("showItem",false);
        } else {
            List<InfoGaterItemDTO> items = itemService.obtainInfoGaterItemsByProjectId(projectId);
            model.put("items", items);
            model.put("showItem",true);
        }

        model.put("project", project);

        MenuKeyProperties.setMenuKey(request, MenuKeyProperties.INFO_GATER, MenuKeyProperties.PROJECT_MANAGE);

        return "projectmanager/projectform";
    }
    @RequestMapping(method= RequestMethod.POST)
    public String saveUserProject(HttpServletRequest request, @ModelAttribute("project") InfoGatherProject project, BindingResult errors, ModelMap model) {
        int userId = SecurityUtils.currectAuthenticationId();
        int projectId = project.getId();
        if (projectId != -1) {
            projectService.updateInfoGaterProject(project);
            return "redirect:projectoverview.html";
        } else {
            project.setRandomKey();
            project.setUserId(userId);
            projectId = projectService.insertInfoGatherProject(project);
            return "redirect:projectform.html?projectId=" + projectId;
        }
    }
}
