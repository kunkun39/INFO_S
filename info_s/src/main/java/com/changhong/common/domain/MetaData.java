package com.changhong.common.domain;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 16:38
 */
public class MetaData {

    /**
     * �����KEYֵ������ibatis���ݿ⽻��ʱ����ͳһ
     **/
    public final static String ID = "id";

    public final static String METADATA_NAME = "metadataName";

    public final static String USER_ID = "userId";

    public final static String PROJECT_ID = "projectId";

    public final static String IS_USED = "isUsed";

    public final static String METADATA_CONTENT = "content";

    /**
     * Ԫ����ID
     **/
    private int id;

    /**
     * ��Ԫ���ݵ�����
     **/
    private String metadataName;

    /**
     * ��Ԫ���ݶ�Ӧ���û�ID
     **/
    private int userId;

    /**
     * ��Ԫ���ݶ�Ӧ�Ĺ���ID
     **/
    private int projectId;

    /**
     * ��Ԫ�����Ƿ�����ʹ��
     **/
    private int isUsed;

    /**
     * Ԫ��������
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
