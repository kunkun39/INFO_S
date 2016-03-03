package com.changhong.system.repository;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.mysql.BasicIbatisDataManager;
import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:16
 */
@Repository("configDao")
public class ConfigDaoImpl extends BasicIbatisDataManager implements ConfigDao {

    public List<Map<String, Object>> loadAllDbConfs() {
        return getSqlMapClientTemplate().queryForList("Config.selectAllDbConfs");
    }

    public Map<String, Object> loadDbConfById(int dbConfId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("dbConfId", dbConfId);

        return (Map<String, Object>) getSqlMapClientTemplate().queryForList("Config.selectDbConfById", parameters).get(0);
    }

    public void updateDbConf(DBConf dbConf) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("host", dbConf.getHost());
        parameters.put("port", dbConf.getPort());
        parameters.put("name", dbConf.getDbName());

        if (dbConf.getId() > 0) {
            parameters.put("id", dbConf.getId());
            getSqlMapClientTemplate().update("Config.updateDbConf", parameters);
        } else {
            getSqlMapClientTemplate().insert("Config.insertDbConf", parameters);
        }
    }

    public List<Map<String, Object>> loadBakUpHistories(int dbConfId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("dbConfId", dbConfId);

        return getSqlMapClientTemplate().queryForList("Config.selectBakUpHistories", parameters);
    }

    public void saveBakUpHistory(DBBakHistory history) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("bakTime", CHJodaUtils.toStringDMYHMS(new DateTime()));
        parameters.put("bakYear", history.getYear());
        parameters.put("bakCode", history.getProjectCode());
        parameters.put("bakProjectId", history.getProjectId());
        parameters.put("bakDbId", history.getDbConfId());

        getSqlMapClientTemplate().insert("Config.insertBakUpHistory", parameters);
    }
}
