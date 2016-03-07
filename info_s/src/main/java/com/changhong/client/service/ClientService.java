package com.changhong.client.service;

import com.alibaba.fastjson.JSONObject;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:41
 */
public interface ClientService {

    /*
     * 通过项目的随机key获取该项目的上报格式
     * @param randomKey
     */
    JSONObject obtainProjectFormat(String randomKey);
}
