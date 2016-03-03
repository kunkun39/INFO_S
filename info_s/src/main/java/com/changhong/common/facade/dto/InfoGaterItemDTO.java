package com.changhong.common.facade.dto;

/**
 * User: pengjie
 * Date: 2016/3/3
 * Time: 9:15
 */
public class InfoGaterItemDTO {
    /**
     * 收集项ID
     **/
    private int id;

    /**
     * 收集项的随机key，客户端上传数据时使用该key值
     **/
    private String itemKey;

    /**
     * 收集项名字
     **/
    private String itemName;

    /**
     * 该收集项对应的工程ID
     **/
    private int projectId;

    /**
     * 元数据ID
     **/
    private int metaDataId;

    /**
     * 该元数据的名字
     **/
    private String metadataName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getMetaDataId() {
        return metaDataId;
    }

    public void setMetaDataId(int metaDataId) {
        this.metaDataId = metaDataId;
    }

    public String getMetadataName() {
        return metadataName;
    }

    public void setMetadataName(String metadataName) {
        this.metadataName = metadataName;
    }
}
