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
}
