package com.changhong.system.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 上午9:42
 */
@Controller
public class SystemUserController {

    private final static String MENU_KEY = "SYS_SETTING";
    private final static String SUB_MENU_KEY = "SETTING_USER";

    @RequestMapping("/system/usermanagement.html")
    public String sendToUserManagement(HttpServletRequest request) {
        setMenuKey(request);

        return "system/user/usermanagement";
    }

    @RequestMapping("/system/userform.html")
    public String sendToUserFrom(HttpServletRequest request) {
        setMenuKey(request);

        return "system/user/userform";
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
