package com.changhong.system.web.controller.setting;

import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;
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
 * User: Jack Wang
 * Date: 16-2-23
 * Time: 下午3:39
 */
@Controller
@RequestMapping("/system/userform.html")
public class SystemUserFormController {

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET)
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

    @RequestMapping(method= RequestMethod.POST)
    public String saveUserFrom(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult errors, ModelMap model) {
        validate(user, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/userform";
        }

        userService.saveUser(user);
        return "redirect:usermanagement.html";
    }

    private void validate(User user, BindingResult errors) {
        if (!StringUtils.hasText(user.getName())) {
            errors.rejectValue("name", "user.name.empty");
        }
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", SystemUserController.MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SystemUserController.SUB_MENU_KEY);
    }
}
