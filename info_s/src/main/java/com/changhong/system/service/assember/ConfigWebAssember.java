package com.changhong.system.service.assember;

import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:28
 */
public class ConfigWebAssember {

    public static SystemConf toConfigDomain(Map<String, Object> model) {
        final int id = (Integer)model.get("id");
        final String confKey = (String)model.get("conf_key");
        final String confValue = (String)model.get("conf_value");

        return new SystemConf(id, confKey, confValue);
    }

    public static List<SystemConf> toConfigDomainList(List<Map<String, Object>> models) {
        List<SystemConf> confs = new ArrayList<SystemConf>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                confs.add(toConfigDomain(model));
            }
        }

        return confs;
    }

    public static SubDBConf toSubDBConfDomain(Map<String, Object> model) {
        final int id = (Integer)model.get("id");
        final String host = (String)model.get("sub_host");
        final String port = (String)model.get("sub_port");
        final String name = (String)model.get("sub_name");

        return new SubDBConf(id, host, port, name);
    }

    public static List<SubDBConf> toSubDBConfDomainList(List<Map<String, Object>> models) {
        List<SubDBConf> confs = new ArrayList<SubDBConf>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                confs.add(toSubDBConfDomain(model));
            }
        }

        return confs;
    }
}
