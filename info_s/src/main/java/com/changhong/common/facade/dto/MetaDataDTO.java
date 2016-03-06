package com.changhong.common.facade.dto;

import java.util.List;
/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 20:22
 */
public class MetaDataDTO {
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
    private boolean used;

    /**
     * 该元数据对应的收集项名字
     **/
    private String itemName;

    /**
     * 该元数据对应的工程名
     **/
    private String projectName;

    /**
     * 元数据内容
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
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<MetaDataSubItem> getItems() {
        return items;
    }

    public void setItems(List<MetaDataSubItem> items) {
        this.items = items;
    }
}
