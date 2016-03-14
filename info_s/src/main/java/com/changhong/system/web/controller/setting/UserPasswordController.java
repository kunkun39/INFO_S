package com.changhong.system.web.controller.setting;

import com.changhong.common.utils.SecurityUtils;
import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 上午9:42
 */
@Controller
@RequestMapping("/system/tochangepassword.html")
public class UserPasswordController {

    public final static String MENU_KEY = "SYS_SETTING";
    public final static String SUB_MENU_KEY = "SETTING_USER";

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String toChangePasswordManagement(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);
        User user2 = SecurityUtils.currentAuthentication();

        user2.setPassword("");
        model.put("user", user2);
        return "system/setting/changepassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String changePasswordForm(HttpServletRequest request,@ModelAttribute("user") User user, BindingResult errors, ModelMap model) {
        if (user==null){
            return  "";
        }
        userService.updatePassword(user.getId(),user.getPassword());

        return "/system/login";
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
