package com.changhong.system.repository;

import com.changhong.system.domain.SubDBConf;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:16
 */
public interface ConfigDao {

    List<Map<String, Object>> loadAllConfigurations();

    void updateConfiguration(String confKey, String confValue);

    List<Map<String, Object>> loadAllSubDBConfs();

    Map<String, Object> loadSubDBConfById(int subDBConfId);

    void updateSubDBConf(SubDBConf subDBConf);
}
