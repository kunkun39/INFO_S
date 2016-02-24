package com.changhong.common.domain;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 11:27
 */
public class InfoGaterProject {

    /**
     * �����KEYֵ������ibatis���ݿ⽻��ʱ����ͳһ
     **/
    public final static String ID = "id";

    public final static String USER_ID = "userId";

    public final static String PROJECT_KEY = "projectKey";

    public final static String PROJECT_NAME = "projectName";

    /**
     * ����ID
     **/
    private int id;

    /**
     * �ù��̶�Ӧ���û�ID
     **/
    private int userId;

    /**
     * ���̵����key���ͻ����ϴ�����ʱʹ�ø�keyֵ
     **/
    private String projectKey;

    /**
     * ��������
     **/
    private String projectName;

    /**
     * ���캯��(��ȡ���еĹ���ʱʹ�øú���)
     **/
    public InfoGaterProject() {
    }

    /**
     * ���캯��(�´���һ���¹���ʱʹ�øú���)
     * @param userId
     * @param projectName
     */
    public InfoGaterProject(int userId, String projectName) {
        this.userId = userId;
        this.projectName = projectName;
        this.projectKey = CHStringUtils.getRandomString(4);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
