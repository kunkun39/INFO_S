package com.changhong.common.facade.dto;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 20:24
 */
public class MetaDataSubItem {

    public static final String INDEX = "index";

    public static final String VALUE = "value";

    /**
     * ��Ԫ�ص�index
     **/
    private String index;

    /**
     * ��Ԫ�ص�ֵ
     **/
    private String value;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
