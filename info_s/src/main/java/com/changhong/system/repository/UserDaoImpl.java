package com.changhong.system.repository;

import com.changhong.mysql.BasicIbatisDataManager;
import com.changhong.system.domain.Role;
import com.changhong.system.domain.RoleInsert;
import com.changhong.system.domain.User;
import com.changhong.system.service.assember.UserWebAssember;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public boolean saveUser(User user) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("name", user.getName());
        parameters.put("contact_way", user.getContactWay());
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        parameters.put("enabled", user.isEnabled());

        getSqlMapClientTemplate().insert("User.insertUser", parameters);

        User savedUser = UserWebAssember.toUserDomain(loadUserByUsername(user.getUsername()));
        if (savedUser != null && savedUser.getId() > 0) {

            List<RoleInsert> myroles = new ArrayList<>();
            for (Role role : user.getRoles()) {
                RoleInsert roleInsert = new RoleInsert();
                roleInsert.userId = savedUser.getId();
                roleInsert.roleType = role.getAuthority();
                myroles.add(roleInsert);
            }
            getSqlMapClientTemplate().insert("User.insertRole", myroles);
            return true;
        } else {
            return false;// can't get the userid,return  saved false ;
        }
    }

    @Override
    public List<Map<String, Object>> loadAllUsers() {

        return getSqlMapClientTemplate().queryForList("User.selectAllUsers");
    }

    @Override
    public void updateUserState(int userid, boolean enable) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("userId", userid);
        parameters.put("enabled", enable ? true : false);

        getSqlMapClientTemplate().update("User.updateUserState", parameters);
    }
}
