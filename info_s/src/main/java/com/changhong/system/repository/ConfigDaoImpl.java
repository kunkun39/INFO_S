package com.changhong.system.repository;

import com.changhong.mysql.BasicIbatisDataManager;
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

    public List<Map<String, Object>> loadAllConfigurations() {
        return getSqlMapClientTemplate().queryForList("Config.selectAllConfigurations");
    }

    public void updateConfiguration(String confKey, String confValue) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("confKey", confKey);
        parameters.put("confValue", confValue);

        getSqlMapClientTemplate().update("Config.updateConfiguration", parameters);
    }
}
