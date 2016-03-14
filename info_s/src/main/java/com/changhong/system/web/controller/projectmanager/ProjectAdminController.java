package com.changhong.system.web.controller.projectmanager;

import com.changhong.common.domain.InfoGatherItem;
import com.changhong.common.domain.InfoGatherProject;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.service.DocumentService;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.MetaDataService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.SecurityUtils;
import com.changhong.system.property.MenuKeyProperties;
import com.changhong.system.web.paging.TestPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * User: pengjie
 * Date: 2016/2/25
 * Time: 9:27
 */
@Controller
public class ProjectAdminController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private MetaDataService metaDataService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/project/projectoverview.html")
    public String sendToProjectOverview(HttpServletRequest request, ModelMap model) {
        int userId = SecurityUtils.currectAuthenticationId();
        List<InfoGatherProject> projects =  projectService.obtainInfoGatherProjectsByUserId(userId);

        model.put("projects", projects);

        MenuKeyProperties.setMenuKey(request, MenuKeyProperties.INFO_GATER, MenuKeyProperties.PROJECT_MANAGE);

        TestPaging paging = new TestPaging();
        paging.setCurrentPageNumber(2);
        model.put("paging", paging);

        return "projectmanager/projectoverview";
    }
    @RequestMapping("/project/projectdeleteform.html")
    public String sendToProjectDeleteForm(HttpServletRequest request, ModelMap model) {
        int projectId = ServletRequestUtils.getIntParameter(request, "projectId", -1);

        projectService.deleteInfoGatherProject(projectId, SecurityUtils.currectAuthenticationId());

        return "redirect:projectoverview.html";
    }

    @RequestMapping("/project/itemeditform.html")
    public String sendToItemEditForm(HttpServletRequest request, ModelMap model) {
        int projectId = ServletRequestUtils.getIntParameter(request, "projectId", -1);
        String itemName = ServletRequestUtils.getStringParameter(request, "name", "");
        String itemKey = ServletRequestUtils.getStringParameter(request, "key", "");
        int itemId = ServletRequestUtils.getIntParameter(request, "itemId", -1);
        boolean useMetadata = ServletRequestUtils.getBooleanParameter(request, "usemetadata", false);
        int metadataId = ServletRequestUtils.getIntParameter(request, "metadataId", -1);

        if (useMetadata) {
            DefaultMultipartHttpServletRequest multipartRequest = (DefaultMultipartHttpServletRequest) request;
            MultipartFile metadataUploadFile = multipartRequest.getFile("metadataUploadFile");
            try {
                MetaDataDTO dto = documentService.parseXML(metadataUploadFile.getInputStream());
                if (dto != null) {
                    dto.setProjectId(projectId);
                    dto.setUserId(SecurityUtils.currectAuthenticationId());
                    dto.setUsed(true);
                    if (metadataId != -1) {
                        dto.setId(metadataId);
                        metaDataService.updateMetaData(dto);
                    } else {
                        metadataId = metaDataService.insertMetaData(dto);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (metadataId != -1) {
                metaDataService.updateDetaDataStatus(metadataId, false);
            }
            metadataId = -1;
        }
        InfoGatherItem item = new InfoGatherItem();
        item.setItemName(itemName);
        item.setItemKey(itemKey);
        item.setMetaDataId(metadataId);
        if (itemId != -1) {
            item.setId(itemId);
            itemService.updateInfoGaterItem(item);
        } else {
            item.setProjectId(projectId);
            itemService.insertInfoGaterItem(item);
        }
        return "redirect:projectform.html?projectId=" + projectId;

    }

    @RequestMapping("/project/itemdeleteform.html")
    public String sendToItemDeleteForm(HttpServletRequest request, ModelMap model) {
        int projectId = ServletRequestUtils.getIntParameter(request, "projectId", -1);
        int itemId = ServletRequestUtils.getIntParameter(request, "itemId", -1);
        int metadataId = ServletRequestUtils.getIntParameter(request, "metadataId", -1);

        itemService.deleteInfoGaterItem(itemId, metadataId);

        return "redirect:projectform.html?projectId=" + projectId;
    }
}
