package com.changhong.system.service.assember;

import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:28
 */
public class ConfigWebAssember {

    public static DBConf toDbConfDomain(Map<String, Object> model) {
        final int id = (Integer)model.get("id");
        final String host = (String)model.get("db_host");
        final String port = (String)model.get("db_port");
        final String name = (String)model.get("db_name");
        final String type = (String)model.get("db_type");

        return new DBConf(id, host, port, name, type);
    }

    public static List<DBConf> toDbConfDomainList(List<Map<String, Object>> models) {
        List<DBConf> confs = new ArrayList<DBConf>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                confs.add(toDbConfDomain(model));
            }
        }

        return confs;
    }

    public static DBBakHistory toDbBakHistoryDomain(Map<String, Object> model) {
        final int id = (Integer)model.get("id");
        final String time = (String)model.get("bak_time");
        final String year = (String)model.get("bak_year");
        final String code = (String)model.get("bak_code");
        final int projectId = (Integer)model.get("bak_project_id");
        final int dbId = (Integer) model.get("bak_db_id");

        return new DBBakHistory(id, time, year, code, projectId, dbId);
    }

    public static List<DBBakHistory> toDbBakHistoryDomainList(List<Map<String, Object>> models) {
        List<DBBakHistory> confs = new ArrayList<DBBakHistory>();

        if (models != null) {
            for (Map<String, Object> model : models) {
                confs.add(toDbBakHistoryDomain(model));
            }
        }

        return confs;
    }
}
