package com.changhong.system.repository;

import com.changhong.system.domain.User;

import java.util.List;
import java.util.Map;

/**
 * User: wangxiufeng
 * Date: 16-2-19
 * Time: 下午5:16
 */
public interface UserDao {

    Map<String, Object> loadUserByUsername(String username);

    List<Map<String, Object>> loadUserRoleByUserId(int userId);

    /**
     * save new user
     * @param user
     */
    void saveUser(User user);

}
