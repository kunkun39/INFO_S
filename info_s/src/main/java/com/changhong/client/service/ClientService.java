package com.changhong.client.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:41
 */
public interface ClientService {

    /**
     * 查找随机key对应的项目ID号
     * @param randomKey
     */
    int obtainProjectId(String randomKey);

    /**
     * 通过项目的ID获取该项目的上报格式
     * @param projectId
     */
    String obtainProjectFormat(int projectId);

    /**
     * 通过项目的ID获取该项目对应的收集项的key集合
     * @param projectId
     */
    List<String> obtainInfogaterItemParam(int projectId);
}
