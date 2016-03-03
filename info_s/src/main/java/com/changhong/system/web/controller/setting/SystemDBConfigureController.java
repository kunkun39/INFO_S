package com.changhong.system.web.controller.setting;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.common.utils.CHValidationUtils;
import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;
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
    public String sendToMainDbSetting(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        List<DBConf> dbs = configService.obtainAllDbConfs();
        model.put("dbs", dbs);

        DBConf mainDB = null;
        for (DBConf db : dbs) {
            if ("MAIN".equals(db.getDbType())) {
                mainDB = db;
            }
        }
        dbs.remove(mainDB);
        model.put("mainDB", mainDB);

        return "system/setting/dbsetting";
    }

    /********************************从数据库的表单**************************************/

    @RequestMapping(value="/system/dbform.html", method= RequestMethod.GET)
    public String setUpDbForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int dbConfId = ServletRequestUtils.getIntParameter(request, "dbConfId", -1);
        DBConf dbConf = null;
        if (dbConfId <= 0) {
            dbConf = new DBConf();
        } else {
            dbConf = configService.obtainDbConfById(dbConfId);
        }
        model.put("dbConf", dbConf);

        return "system/setting/dbform";
    }

    @RequestMapping(value="/system/dbform.html", method= RequestMethod.POST)
    public String saveDbFrom(HttpServletRequest request, @ModelAttribute("dBConf") DBConf dbConf, BindingResult errors, ModelMap model) {
        validateDbForm(dbConf, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/dbform";
        }

        configService.saveDbConf(dbConf);
        return "redirect:dbsetting.html";
    }

    private void validateDbForm(DBConf dbConf, BindingResult errors) {
        String host = dbConf.getHost();
        String port = dbConf.getPort();
        String name = dbConf.getDbName();

        if (!StringUtils.hasText(host)) {
            errors.rejectValue("host", "db.host.empty");
        } else {
            if (!CHValidationUtils.isRightIPAddress(host)) {
                errors.rejectValue("host", "db.host.format");
            }
        }

        if (!StringUtils.hasText(port)) {
            errors.rejectValue("port", "db.port.empty");
        } else {
            try {
                Integer.valueOf(port);
            } catch (Exception e) {
                errors.rejectValue("port", "db.port.format");
            }
        }

        if (!StringUtils.hasText(name)) {
            errors.rejectValue("dbName", "db.dbname.empty");
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
    public String sendToBakupDbInfoSetting(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int dbConfId = ServletRequestUtils.getIntParameter(request, "dbConfId", -1);

        DBConf dbConf = configService.obtainDbConfById(dbConfId);
        model.put("dbConf", dbConf);

        List<DBBakHistory> histories = configService.obtainBakUpHistories(dbConfId);
        model.put("histories", histories);

        return "system/setting/bakuphistoryoverview";
    }

    @RequestMapping(value = "/system/bakuphistoryform.html", method= RequestMethod.GET)
    public String setUpForm(HttpServletRequest request, ModelMap model) {
        setMenuKey(request);

        int dbConfId = ServletRequestUtils.getIntParameter(request, "dbConfId", -1);
        DBBakHistory history = new DBBakHistory(dbConfId);
        model.put("history", history);
        model.put("dbConfId", dbConfId);

        int currentYear = Integer.valueOf(CHJodaUtils.toYearString(new DateTime()));
        model.put("currentYear", currentYear);

        return "system/setting/bakuphistoryform";
    }

    @RequestMapping(value = "/system/bakuphistoryform.html", method= RequestMethod.POST)
    public String saveUserFrom(HttpServletRequest request, @ModelAttribute("history") DBBakHistory history, BindingResult errors, ModelMap model) {
        validateBakUpHistory(history, errors);

        if (errors.hasErrors()) {
            model.putAll(errors.getModel());
            return "system/setting/bakuphistoryform";
        }

        configService.saveBakUpDbHistory(history);
        return "redirect:bakuphistoryoverview.html?dbConfId=" + history.getDbConfId();
    }

    private void validateBakUpHistory(DBBakHistory history, BindingResult errors) {
    }

    private void setMenuKey(HttpServletRequest request) {
        request.getSession().setAttribute("MENU_KEY", MENU_KEY);
        request.getSession().setAttribute("SUB_MENU_KEY", SUB_MENU_KEY);
    }
}
