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
@Repository("userDao")
public class UserDaoImpl extends BasicIbatisDataManager implements UserDao {

    public Map<String, Object> loadUserByUsername(String username) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("username", username);

        List<HashMap> pages = getSqlMapClientTemplate().queryForList("User.selectUserByUsername", parameters);

        if (pages == null || pages.isEmpty()) {
            return null;
        }
        return pages.get(0);
    }

    public List<Map<String, Object>> loadUserRoleByUserId(int userId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        return getSqlMapClientTemplate().queryForList("User.selectUserRoleByUserId", parameters);
    }
}
