package com.changhong.system.web.controller.setting;

import com.changhong.system.domain.RoleType;
import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户添加Controller
 * User: wangxiufeng
 * Date: 16-2-23
 * Time: 下午3:39
 */
@Controller
@RequestMapping("/system/userform.html")
public class SystemUserFormController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);
        User user = null;
        if (userId <= 0) {
            user = new User();
        } else {
            user = userService.obtainUserById(userId);
        }
        model.put("user", user);

        return "system/setting/userform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUserFrom(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult errors, ModelMap model) {

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/userform";
        }
        int[] roles = ServletRequestUtils.getIntParameters(request, "membership");
        if (roles != null && roles.length > 0) {
            for (int i = 0; i < roles.length; i++) {
//                System.out.println("---m---"+roles[i]);
                if (roles[i]==1){
                    //系统管理员
                    user.grantRole(RoleType.ROLE_ADMIN.toString());
                }else if (roles[i]==2){
                    //系统管理员
                    user.grantRole(RoleType.ROLE_PROJECT.toString());
                }
            }
        }
//        System.out.println("---rolesize---"+user.getRoles().size());
        userService.saveUser(user);
        return "redirect:usermanagement.html";
    }


    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", SystemUserController.MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SystemUserController.SUB_MENU_KEY);
    }
}
