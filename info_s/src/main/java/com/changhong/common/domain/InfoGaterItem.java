package com.changhong.common.domain;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 14:20
 */
public class InfoGaterItem {

    /**
     * 定义的KEY值，用于ibatis数据库交互时进行统一
     **/
    public final static String ID = "id";

    public final static String ITEM_KEY = "itemKey";

    public final static String ITEM_NAME = "itemName";

    public final static String PROJECT_ID = "projectId";

    public final static String ITEM_CONTENT = "itemContent";

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
     * 该收集项的所有子项的详细信息，使用json格式封装
     **/
    private String itemContent;

    /**
     * 构造函数(读取已有的收集项时使用该函数)
     **/
    public InfoGaterItem() {
    }

    /**
     * 构造函数(新创建一个新收集项时使用该函数)
     * @param itemName
     * @param projectId
     * @param itemContent
     */
    public InfoGaterItem(String itemName, int projectId, String itemContent) {
        this.itemName = itemName;
        this.projectId = projectId;
        this.itemContent = itemContent;
        this.itemKey = CHStringUtils.getRandomString(4);
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

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }
}
