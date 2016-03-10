package com.changhong.common.domain;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 14:20
 */
public class InfoGatherItem {

    /**
     * 定义的KEY值，用于ibatis数据库交互时进行统一
     **/
    public final static String ID = "id";

    public final static String ITEM_KEY = "itemKey";

    public final static String ITEM_NAME = "itemName";

    public final static String PROJECT_ID = "projectId";

    public final static String METADATA_ID = "metaDataId";

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
     * 构造函数(读取已有的收集项时使用该函数)
     **/
    public InfoGatherItem() {
    }

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
}
