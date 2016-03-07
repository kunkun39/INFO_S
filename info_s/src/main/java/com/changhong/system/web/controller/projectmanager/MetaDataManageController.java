package com.changhong.system.web.controller.projectmanager;

import com.changhong.common.facade.dto.MetaDataDTO;
import com.changhong.common.service.DocumentService;
import com.changhong.common.service.MetaDataService;
import com.changhong.common.utils.SecurityUtils;
import com.changhong.system.property.MenuKeyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/4
 * Time: 8:53
 */
@Controller
public class MetaDataManageController {
    @Autowired
    private MetaDataService metaDataService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/project/metadataoverview.html")
    public String sendToMetaDataOverview(HttpServletRequest request, ModelMap model) {
        int userId = SecurityUtils.currectAuthenticationId();
        int projectId = ServletRequestUtils.getIntParameter(request, "projectId", -1);

        List<MetaDataDTO> metaDataDTOList =  metaDataService.obtainMetaDataByIds(userId, projectId);

        model.put("metaDatas", metaDataDTOList);

        MenuKeyProperties.setMenuKey(request, MenuKeyProperties.INFO_GATER, MenuKeyProperties.METADATA_MANAGE);

        return "projectmanager/metadataoverview";
    }

    @RequestMapping("/project/metadatadetails.html")
    public String sendToMetaDataDetails(HttpServletRequest request, ModelMap model) {
        int userId = SecurityUtils.currectAuthenticationId();
        int metadataId = ServletRequestUtils.getIntParameter(request, "metadataId", -1);

        MetaDataDTO dto = metaDataService.obtainMetaDataBySelfId(metadataId, userId);

        model.put("metadata", dto);

        return "projectmanager/metadatadetails";
    }

    @RequestMapping("/project/metadataexport.html")
    public ModelAndView sendToExportMetaData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = SecurityUtils.currectAuthenticationId();
        int metadataId = ServletRequestUtils.getIntParameter(request, "metadataId", -1);

        MetaDataDTO dto = metaDataService.obtainMetaDataBySelfId(metadataId, userId);
        if (dto != null) {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-Type", "application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(dto.getMetadataName().getBytes("gb2312"), "ISO8859-1" ) + ".xml\"");
            OutputStream os = response.getOutputStream();
            documentService.writeToXML(os, dto);
            os.close();
        }
        return null;
    }

    @RequestMapping("/project/metadatadeleteform.html")
    public String sendToDelateMetadata(HttpServletRequest request) {
        int userId = SecurityUtils.currectAuthenticationId();
        int metadataId = ServletRequestUtils.getIntParameter(request, "metadataId", -1);

        metaDataService.deletaMetadataBySelfId(metadataId, userId);

        return "redirect:metadataoverview.html";
    }

}
