package com.changhong.system.repository;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.mysql.BasicIbatisDataManager;
import com.changhong.system.domain.SubDBBakHistory;
import com.changhong.system.domain.SubDBConf;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    public List<Map<String, Object>> loadAllConfigurations() {
        return getSqlMapClientTemplate().queryForList("Config.selectAllConfigurations");
    }

    public void updateConfiguration(String confKey, String confValue) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("confKey", confKey);
        parameters.put("confValue", confValue);

        getSqlMapClientTemplate().update("Config.updateConfiguration", parameters);
    }

    public List<Map<String, Object>> loadAllSubDBConfs() {
        return getSqlMapClientTemplate().queryForList("Config.selectAllSubDBConfs");
    }

    public Map<String, Object> loadSubDBConfById(int subDBConfId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("subDBConfId", subDBConfId);

        return (Map<String, Object>) getSqlMapClientTemplate().queryForList("Config.selectSubDBConfById", parameters).get(0);
    }

    public void updateSubDBConf(SubDBConf subDBConf) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("host", subDBConf.getHost());
        parameters.put("port", subDBConf.getPort());
        parameters.put("name", subDBConf.getDbName());

        if (subDBConf.getId() > 0) {
            parameters.put("id", subDBConf.getId());
            getSqlMapClientTemplate().update("Config.updateSubDBConf", parameters);
        } else {
            getSqlMapClientTemplate().insert("Config.insertSubDBConf", parameters);
        }
    }

    public List<Map<String, Object>> loadBakUpHistories(int subDBConfId) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("subDBConfId", subDBConfId);

        return getSqlMapClientTemplate().queryForList("Config.selectBakUpHistories", parameters);
    }

    public void saveBakUpHistory(SubDBBakHistory history) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("bakTime", CHJodaUtils.toStringDMYHMS(new DateTime()));
        parameters.put("bakYear", history.getYear());
        parameters.put("bakCode", history.getProjectCode());
        parameters.put("bakProjectId", history.getProjectId());
        parameters.put("bakSubdbId", history.getSubDBConfId());

        getSqlMapClientTemplate().insert("Config.insertBakUpHistory", parameters);
    }
}
