package com.changhong.system.web.controller.setting;

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

    private final static String MENU_KEY = "SYS_SETTING";
    private final static String SUB_MENU_KEY = "SETTING_CONF";

    @Autowired
    private ConfigService configService;

    @RequestMapping("/system/settingmanagement.html")
    public String sendToConfiguration(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        List<SystemConf> confs = configService.obtainAllConfigurations();
        model.put("confs", confs);

        return "system/setting/settingmanagement";
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
