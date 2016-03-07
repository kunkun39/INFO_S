package com.changhong.client.domain;

/**
 * User: pengjie
 * Date: 2016/2/22
 * Time: 9:43
 */
public enum ResponseCode {
    SUCCESS(1000), //数据采集成功
    PROJECTNOTEXIST(1001), //项目不存在
    BASICDATAMISS(1002), //基础数据丢失
    FORMATERROR(1003), //数据格式错误
    PARAMERROR(1004),  //参数错误
    ORTHERERROR(1005); //其他错误

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
