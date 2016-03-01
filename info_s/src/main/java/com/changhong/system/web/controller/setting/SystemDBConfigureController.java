package com.changhong.system.web.controller.setting;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.common.utils.CHValidationUtils;
import com.changhong.system.domain.SubDBBakHistory;
import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;
import com.changhong.system.service.ConfigService;
import org.joda.time.DateTime;
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
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午3:20
 */
@Controller
public class SystemDBConfigureController {

    public final static String MENU_KEY = "SYS_SETTING";
    public final static String SUB_MENU_KEY = "MAIN_DB_CONF";

    @Autowired
    private ConfigService configService;

    /********************************查看所有数据库的配置**************************************/

    @RequestMapping("/system/dbsetting.html")
    public String sendToMainDBSetting(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        List<SystemConf> confs = configService.obtainAllConfigurations();
        model.put("confs", confs);

        List<SubDBConf> subDBs = configService.obtainAllSubDBConfs();
        model.put("subDBs", subDBs);

        return "system/setting/dbsetting";
    }

    /********************************从数据库的表单**************************************/

    @RequestMapping(value="/system/subdbform.html", method= RequestMethod.GET)
    public String setUpSubDBForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int subDBConfId = ServletRequestUtils.getIntParameter(request, "subDBConfId", -1);
        SubDBConf subDBConf = null;
        if (subDBConfId <= 0) {
            subDBConf = new SubDBConf();
        } else {
            subDBConf = configService.obtainSubDBConfById(subDBConfId);
        }
        model.put("subDBConf", subDBConf);

        return "system/setting/subdbform";
    }

    @RequestMapping(value="/system/subdbform.html", method= RequestMethod.POST)
    public String saveSubDBFrom(HttpServletRequest request, @ModelAttribute("subDBConf") SubDBConf subDBConf, BindingResult errors, ModelMap model) {
        validateSubDBForm(subDBConf, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/subdbform";
        }

        configService.saveSubDBConf(subDBConf);
        return "redirect:dbsetting.html";
    }

    private void validateSubDBForm(SubDBConf subDBConf, BindingResult errors) {
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

    /********************************备份数据库历史**************************************/

    @RequestMapping("/system/bakuphistoryoverview.html")
    public String sendToBakupDBInfoSetting(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int subDBConfId = ServletRequestUtils.getIntParameter(request, "subDBConfId", -1);

        SubDBConf subDBConf = configService.obtainSubDBConfById(subDBConfId);
        model.put("subDBConf", subDBConf);

        List<SubDBBakHistory> histories = configService.obtainBakUpHistories(subDBConfId);
        model.put("histories", histories);

        return "system/setting/bakuphistoryoverview";
    }

    @RequestMapping(value = "/system/bakuphistoryform.html", method= RequestMethod.GET)
    public String setUpForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int subDBConfId = ServletRequestUtils.getIntParameter(request, "subDBConfId", -1);
        SubDBBakHistory history = new SubDBBakHistory(subDBConfId);
        model.put("history", history);

        int currentYear = Integer.valueOf(CHJodaUtils.toYearString(new DateTime()));
        model.put("currentYear", currentYear);

        return "system/setting/bakuphistoryform";
    }

    @RequestMapping(value = "/system/bakuphistoryform.html", method= RequestMethod.POST)
    public String saveUserFrom(HttpServletRequest request, @ModelAttribute("history") SubDBBakHistory history, BindingResult errors, ModelMap model) {
        validateBakUpHistory(history, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/bakuphistoryform";
        }

        configService.saveBakUpDBHistory(history);
        return "redirect:bakuphistoryoverview.html?subDBConfId=" + history.getSubDBConfId();
    }

    private void validateBakUpHistory(SubDBBakHistory history, BindingResult errors) {
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
