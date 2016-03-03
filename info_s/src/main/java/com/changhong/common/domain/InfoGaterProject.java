package com.changhong.common.domain;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 11:27
 */
public class InfoGaterProject {

    /**
     * 定义的KEY值，用于ibatis数据库交互时进行统一
     **/
    public final static String ID = "id";

    public final static String USER_ID = "userId";

    public final static String PROJECT_KEY = "projectKey";

    public final static String PROJECT_NAME = "projectName";

    /**
     * 工程ID
     **/
    private int id;

    /**
     * 该工程对应的用户ID
     **/
    private int userId;

    /**
     * 工程的随机key，客户端上传数据时使用该key值
     **/
    private String projectKey;

    /**
     * 工程名字
     **/
    private String projectName;

    /**
     * 构造函数(读取已有的工程时使用该函数)
     **/
    public InfoGaterProject() {
        this.id = -1;
    }

    /**
     * 构造函数(新创建一个新工程时使用该函数)
     * @param userId
     * @param projectName
     */
    public InfoGaterProject(int userId, String projectName) {
        this.userId = userId;
        this.projectName = projectName;
        this.projectKey = CHStringUtils.getRandomString(4);
    }

    /**
     * 设置随机Key值
     */
    public void setRandomKey() {
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
