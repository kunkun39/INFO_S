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
            usernamestate = 1;//�˺�Ϊ��
        } else {
            User user = (User) userService.loadUserByUsername(username);
            if (user == null || user.getId() <= 0) {
                usernamestate = 0;//����ע��
            } else {
                usernamestate = 3;//�˺Ŵ���
            }
        }
        return usernamestate;
    }

    /**
     * ��ȡ�ռ�����ϱ���ʽ
     *
     * @param projectId
     * @return json�ַ���
     */
    public String obtainInfoDataFormat(int projectId) {
        int userId = SecurityUtils.currectAuthenticationId();
        if (userId >= 0 && projectId >= 0) {
            String format = projectService.obtainProjectJsonFormat(projectId, userId);
            if (format != null) {
                return format.replace("value", "<font color=\"red\">value</font>");
            }
        }
        return null;
    }

    /**
     * ����û��һ�����ʱ�������ԭʼ����
     *
     * @param password
     * @return 0����������ȷ  1������Ϊ�� �� 2����½�û���Ϣ��ȡ�쳣 3�����벻��ȷ
     */
    public int checkUserPassword(String password) {
        int passwordState = 1;
        if (password == null || password.equals("")) {
            passwordState = 1;//����Ϊ��
        } else {
            User user = userService.obtainUserById(SecurityUtils.currectAuthenticationId());
            if (user == null) {
                passwordState = 2;//�û�δ��½���½����
            } else {
                if (password.equals(user.getPassword())) {
                    passwordState = 0;//������������ȷ
                } else {
                    passwordState = 3;//���벻��ȷ
                }
            }
        }
        return passwordState;
    }
}
