package com.changhong.system.service;

import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午5:45
 */
public interface ConfigService {

    List<SystemConf> obtainAllConfigurations();

    void updateConfiguration(String confKey, String confValue);

    List<SubDBConf> obtainAllSubDBConfs();

    SubDBConf obtainSubDBConfById(int subDBConfId);

    void saveSubDBConf(SubDBConf subDBConf);
}
