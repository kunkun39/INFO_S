package com.changhong.system.service;

import com.changhong.system.domain.SubDBBakHistory;
import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午5:45
 */
public interface ConfigService {

//    Main DB

    List<SystemConf> obtainAllConfigurations();

    void updateConfiguration(String confKey, String confValue);

//    Sub DB

    List<SubDBConf> obtainAllSubDBConfs();

    SubDBConf obtainSubDBConfById(int subDBConfId);

    void saveSubDBConf(SubDBConf subDBConf);

//    Bak Up History

    List<SubDBBakHistory> obtainBakUpHistories(int subDBConfId);

    void saveBakUpDBHistory(SubDBBakHistory history);
}
