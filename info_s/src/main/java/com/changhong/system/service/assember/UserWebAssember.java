package com.changhong.system.service.assember;

import com.changhong.system.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:28
 */
public class UserWebAssember {

    public static User toUserDomain(Map<String, Object> model) {
        final int id = (Integer) model.get("id");
        final String name = (String) model.get("name");
        final String contactWay = (String) model.get("contact_way");
        final String username = (String) model.get("username");
        final String password = (String) model.get("password");
        final boolean enabled = (Boolean) model.get("enabled");

        return new User(id, name, contactWay, username, password, enabled);
    }

    public static void addUserRoleDomain(User user, List<Map<String, Object>> models) {
        for (Map<String, Object> model : models) {
            String roleType = (String) model.get("role_type");
            user.grantRole(roleType);
        }
    }

    public static List<User> toUserListDomain(List<Map<String, Object>> models) {
        List<User> users = new ArrayList<User>();
        if (models == null || models.size() <= 0) {
            return users;
        }
        for (int i = 0; i < models.size(); i++) {
            users.add(toUserDomain(models.get(i)));
        }
        return users;
    }
}
