package com.changhong.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:41
 */
public interface ClientService {

    /*
     * ͨ����Ŀ�����key��ȡ����Ŀ���ϱ���ʽ
     * @param randomKey
     */
    JSONObject obtainProjectFormat(String randomKey);
}
