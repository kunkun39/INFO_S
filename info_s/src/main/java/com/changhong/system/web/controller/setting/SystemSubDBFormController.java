package com.changhong.system.web.controller.setting;

import com.changhong.common.utils.CHValidationUtils;
import com.changhong.mongodb.MongoDBManagerImpl;
import com.changhong.system.domain.SubDBConf;
import com.changhong.system.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * User: Jack Wang
 * Date: 16-2-25
 * Time: 下午5:08
 */
@Controller
@RequestMapping("/system/subdbform.html")
public class SystemSubDBFormController {

    @Autowired
    private ConfigService configService;

    @RequestMapping(method= RequestMethod.GET)
    public String setUpForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int subDBConfId = ServletRequestUtils.getIntParameter(request, "subDBConfId", -1);
        SubDBConf subDBConf = null;
        if (subDBConfId <= 0) {
            subDBConf = new SubDBConf();
        } else {
            subDBConf = configService.obtainSubDBConfById(subDBConfId);
        }
        model.put("subDBConf", subDBConf);

        return "system/setting/subdbconfform";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String saveUserFrom(HttpServletRequest request, @ModelAttribute("subDBConf") SubDBConf subDBConf, BindingResult errors, ModelMap model) {
        validate(subDBConf, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/subdbconfform";
        }

        configService.saveSubDBConf(subDBConf);
        return "redirect:dbsetting.html";
    }

    private void validate(SubDBConf subDBConf, BindingResult errors) {
        String host = subDBConf.getHost();
        String port = subDBConf.getPort();
        String name = subDBConf.getDbName();

        if (!StringUtils.hasText(host)) {
            errors.rejectValue("host", "subdb.host.empty");
        } else {
            if (!CHValidationUtils.isRightIPAddress(host)) {
                errors.rejectValue("host", "subdb.host.format");
            }
        }

        if (!StringUtils.hasText(port)) {
            errors.rejectValue("port", "subdb.port.empty");
        } else {
            try {
                Integer.valueOf(port);
            } catch (Exception e) {
                errors.rejectValue("port", "subdb.port.format");
            }
        }

        if (!StringUtils.hasText(name)) {
            errors.rejectValue("dbName", "subdb.dbname.empty");
        }
        if (!errors.hasErrors()) {
            /**
             * 数据库连接检查
            if (!MongoDBManagerImpl.isMongoDBServerConnect(host, port, name)) {
                errors.rejectValue("dbName", "subdb.server.cannot.connect");
            }
            **/
        }
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", SystemConfigureController.MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SystemConfigureController.SUB_MENU_KEY);
    }
}
