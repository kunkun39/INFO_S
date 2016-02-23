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
        return null;
    }

    public void saveUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
