package com.changhong.system.web.dwr;

import com.changhong.common.service.ProjectService;
import com.changhong.common.utils.SecurityUtils;
import com.changhong.system.domain.User;
import com.changhong.system.service.ConfigService;
import com.changhong.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("systemDWRHandler")
public class SystemDWRHandler {

    @Autowired
    private ConfigService configService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    public int checkUserNameInfo(String username) {
        int usernamestate = 1;
        if (username == null || username.equals("")) {
            usernamestate = 1;//账号为空
        } else {
            User user = (User) userService.loadUserByUsername(username);
            if (user == null || user.getId() <= 0) {
                usernamestate = 0;//可以注册
            } else {
                usernamestate = 3;//账号存在
            }
        }
        return usernamestate;
    }

    /**
     * 获取收集项的上报格式
     * @param projectId
     * @return json字符串
     */
    public String obtainInfoDataFormat(int projectId) {
        int userId = SecurityUtils.currectAuthenticationId();
        if (userId >= 0 && projectId >= 0) {
            String format =  projectService.obtainProjectJsonFormat(projectId, userId);
            if (format != null) {
                return format.replace("value", "<font color=\"red\">value</font>");
            }
        }
        return null;
    }
}
