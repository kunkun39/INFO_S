package com.changhong.system.web.dwr;

import com.changhong.system.domain.User;
import com.changhong.system.service.ConfigService;
import com.changhong.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemDWRHandler")
public class SystemDWRHandler {

    @Autowired
    private ConfigService configService;
    @Autowired
    private UserService userService;

    public int checkUserNameInfo(String username) {
        int usernamestate = 1;
        if (username == null || username.equals("")) {
            usernamestate = 1;//ÕËºÅÎª¿Õ
        } else {
            User user = (User) userService.loadUserByUsername(username);
            if (user == null || user.getId() <= 0) {
                usernamestate = 0;//¿ÉÒÔ×¢²á
            } else {
                usernamestate = 3;//ÕËºÅ´æÔÚ
            }
        }
        return usernamestate;
    }
}
