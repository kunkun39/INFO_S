package com.changhong.system.repository;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:16
 */
public interface UserDao {

    Map<String, Object> loadUserByUsername(String username);

    List<Map<String, Object>> loadUserRoleByUserId(int userId);
}
