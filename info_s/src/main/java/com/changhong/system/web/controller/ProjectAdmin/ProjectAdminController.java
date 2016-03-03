package com.changhong.system.web.controller.ProjectAdmin;

import com.changhong.common.domain.InfoGaterItem;
import com.changhong.common.domain.InfoGaterProject;
import com.changhong.common.facade.assember.MetaDataWebAssember;
import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.service.DocumentService;
import com.changhong.common.service.ItemService;
import com.changhong.common.service.MetaDataService;
import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.SecurityUtils;
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

    private final static String MENU_KEY = "MENU_KEY";

    private final static String SUB_MENU_KEY = "SUB_MENU_KEY";

    private final static String INFO_GATER = "INFO_GATER";

    private final static String PROJECT_MANAGE = "PROJECT_MANAGE";

    private final static String METADATA_MANAGE = "METADATA_MANAGE";

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
        List<InfoGaterProject> projects =  projectService.obtainInfoGaterProjectsByUserId(userId);

        model.put("projects", projects);

        setMenuKey(request, INFO_GATER, PROJECT_MANAGE);
        return "projectadmin/projectoverview";
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
                    dto.setIsUsed(true);
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
        InfoGaterItem item = new InfoGaterItem();
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

//        setMenuKey(request, INFO_GATER, PROJECT_MANAGE);
//        InfoGaterProject project = new InfoGaterProject();
//        model.put("project", project);
//        return "projectadmin/projectform";
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

    private void setMenuKey(HttpServletRequest request , String menuKey, String subMenuKey) {
        request.getSession().setAttribute(MENU_KEY, menuKey);
        request.getSession().setAttribute(SUB_MENU_KEY, subMenuKey);
    }
}
