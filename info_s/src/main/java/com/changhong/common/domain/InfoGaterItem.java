package com.changhong.common.domain;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: pengjie
 * Date: 2016/2/24
 * Time: 14:20
 */
public class InfoGaterItem {

    /**
     * �����KEYֵ������ibatis���ݿ⽻��ʱ����ͳһ
     **/
    public final static String ID = "id";

    public final static String ITEM_KEY = "itemKey";

    public final static String ITEM_NAME = "itemName";

    public final static String PROJECT_ID = "projectId";

    public final static String ITEM_CONTENT = "itemContent";

    /**
     * �ռ���ID
     **/
    private int id;

    /**
     * �ռ�������key���ͻ����ϴ�����ʱʹ�ø�keyֵ
     **/
    private String itemKey;

    /**
     * �ռ�������
     **/
    private String itemName;

    /**
     * ���ռ����Ӧ�Ĺ���ID
     **/
    private int projectId;

    /**
     * ���ռ���������������ϸ��Ϣ��ʹ��json��ʽ��װ
     **/
    private String itemContent;

    /**
     * ���캯��(��ȡ���е��ռ���ʱʹ�øú���)
     **/
    public InfoGaterItem() {
    }

    /**
     * ���캯��(�´���һ�����ռ���ʱʹ�øú���)
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
