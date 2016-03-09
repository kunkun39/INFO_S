package com.changhong.system.service;

import com.changhong.system.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:20
 */
public interface UserService extends UserDetailsService {

    User obtainUserById(int userId);

    void saveUser(User user);

    List<User> loadAllUsers();

    /**
     * 更改用戶状态
     * @param enable true：改为正常状态； false： 改为禁用
     */
    void updateUserState(int userid,boolean enable);
}
