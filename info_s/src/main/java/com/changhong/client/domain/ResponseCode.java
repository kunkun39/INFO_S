package com.changhong.client.domain;

/**
 * User: pengjie
 * Date: 2016/2/22
 * Time: 9:43
 */
public enum ResponseCode {
    SUCCESS(1000), //���ݲɼ��ɹ�
    PROJECTNOTEXIST(1001), //��Ŀ������
    BASICDATAMISS(1002), //�������ݶ�ʧ
    FORMATERROR(1003), //���ݸ�ʽ����
    ORTHERERROR(1004); //��������

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
