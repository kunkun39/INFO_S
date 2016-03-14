package com.changhong.system.service;

import com.changhong.system.domain.User;
import com.changhong.system.service.assember.UserWebAssember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.changhong.system.repository.UserDao;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Map<String, Object> user = userDao.loadUserByUsername(username);
        if (user == null) {
            return null;
        }

        User userDetails = UserWebAssember.toUserDomain(user);
        List<Map<String,Object>> roles = userDao.loadUserRoleByUserId(userDetails.getId());
        UserWebAssember.addUserRoleDomain(userDetails, roles);
        return userDetails;
    }

    public User obtainUserById(int userId) {
        Map<String, Object> userMap = userDao.loadUserById(userId);
        if (userMap == null) {
            return null;
        }
        User user = UserWebAssember.toUserDomain(userMap);
        List<Map<String,Object>> roles = userDao.loadUserRoleByUserId(user.getId());
        UserWebAssember.addUserRoleDomain(user, roles);
        return user;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> loadAllUsers() {
        List<Map<String, Object>> users=userDao.loadAllUsers();

        return UserWebAssember.toUserListDomain(users);
    }

    @Override
    public void updateUserState(int userid,boolean enable) {
         userDao.updateUserState(userid,enable);
    }

    @Override
    public void updatePassword(int userid, String newPassword) {
        userDao.updatePassword(userid, newPassword);
    }
}
