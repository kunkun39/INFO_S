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

    Map<String, Object> loadUserById(int userid);

    Map<String, Object> loadUserByUsername(String username);

    List<Map<String, Object>> loadUserRoleByUserId(int userId);

    /**
     * save new user
     *
     * @param user
     * @return isSuccess
     */
    boolean saveUser(User user);

    List<Map<String, Object>> loadAllUsers();

    List<Map<String, Object>> loadAnyUsers(int startPostion, int count);

    /**
     * 更改用戶状态
     *
     * @param enable true：改为正常状态； false： 改为禁用
     */
    void updateUserState(int userid, boolean enable);

    void updatePassword(int userid, String newPassword);
}
