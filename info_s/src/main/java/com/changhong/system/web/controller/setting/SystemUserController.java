package com.changhong.system.web.controller.setting;

import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;
import com.changhong.system.web.paging.UserManagePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public String sendToUserManagement(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int current = ServletRequestUtils.getIntParameter(request, "current", 1);

        UserManagePaging paging = new UserManagePaging(userService);
        constructPaging(paging, current);


        List<User> users = paging.getItems();
        model.put("paging", paging);
        model.put("users", users);
        return "system/setting/usermanagement";
    }

    @RequestMapping("/system/userdisable.html")
    public String saveUserFrom(HttpServletRequest request, ModelMap model) {

        try {
            boolean nowenabled = ServletRequestUtils.getBooleanParameter(request, "nowenabled");//true 執行禁用操作,false 執行解除禁用操作
            int userid = ServletRequestUtils.getIntParameter(request, "userid", 0);
            if (userid > 0){
                userService.updateUserState(userid,!nowenabled);
            }

        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }

        return sendToUserManagement(request,model);
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }


    private void constructPaging(UserManagePaging paging, int current) {
        paging.setCurrentPageNumber(current);
    }


}
