package com.changhong.common.facade.dto;

import java.util.List;
/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 20:22
 */
public class MetaDataDTO {
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
    private boolean isUsed;

    /**
     * Ԫ��������
     **/
    private List<MetaDataSubItem> items;

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

    public boolean isUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public List<MetaDataSubItem> getItems() {
        return items;
    }

    public void setItems(List<MetaDataSubItem> items) {
        this.items = items;
    }
}
