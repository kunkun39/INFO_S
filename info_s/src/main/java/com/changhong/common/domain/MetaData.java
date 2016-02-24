package com.changhong.common.domain;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 16:38
 */
public class MetaData {

    /**
     * 定义的KEY值，用于ibatis数据库交互时进行统一
     **/
    public final static String ID = "id";

    public final static String METADATA_NAME = "metadataName";

    public final static String USER_ID = "userId";

    public final static String PROJECT_ID = "projectId";

    public final static String IS_USED = "isUsed";

    public final static String METADATA_CONTENT = "content";

    /**
     * 元数据ID
     **/
    private int id;

    /**
     * 该元数据的名字
     **/
    private String metadataName;

    /**
     * 该元数据对应的用户ID
     **/
    private int userId;

    /**
     * 该元数据对应的工程ID
     **/
    private int projectId;

    /**
     * 该元数据是否有在使用
     **/
    private int isUsed;

    /**
     * 元数据内容
     **/
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetadataName() {
        return metadataName;
    }

    public void setMetadataName(String metadataName) {
        this.metadataName = metadataName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
