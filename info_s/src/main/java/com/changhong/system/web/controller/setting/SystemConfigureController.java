package com.changhong.system.web.controller.setting;

import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;
import com.changhong.system.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午3:20
 */
@Controller
public class SystemConfigureController {

    public final static String MENU_KEY = "SYS_SETTING";
    public final static String SUB_MENU_KEY = "MAIN_DB_CONF";

    @Autowired
    private ConfigService configService;

    @RequestMapping("/system/dbsetting.html")
    public String sendToMainDBSetting(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        List<SystemConf> confs = configService.obtainAllConfigurations();
        model.put("confs", confs);

        List<SubDBConf> subDBs = configService.obtainAllSubDBConfs();
        model.put("subDBs", subDBs);

        return "system/setting/maindbsetting";
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
