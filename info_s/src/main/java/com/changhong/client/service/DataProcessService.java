package com.changhong.client.service;

import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/8
 * Time: 10:09
 */
public interface DataProcessService {

    void init();

    boolean insertData(Map<String, Object> map);

    boolean insertData(List<Map<String, Object>> list);

    void stop();
}
