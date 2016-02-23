package com.changhong.system.web.controller.setting;

import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 上午9:42
 */
@Controller
public class SystemUserController {

    public final static String MENU_KEY = "SYS_SETTING";
    public final static String SUB_MENU_KEY = "SETTING_USER";

    @Autowired
    private UserService userService;

    @RequestMapping("/system/usermanagement.html")
    public String sendToUserManagement(HttpServletRequest request) {
        setMenuKey(request);

        return "system/setting/usermanagement";
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
