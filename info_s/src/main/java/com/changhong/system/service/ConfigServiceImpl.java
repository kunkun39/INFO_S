package com.changhong.system.service;

import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;
import com.changhong.system.repository.ConfigDao;
import com.changhong.system.service.assember.ConfigWebAssember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午5:45
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigDao configDao;

    public List<SystemConf> obtainAllConfigurations() {
        List<Map<String, Object>> confs = configDao.loadAllConfigurations();
        return ConfigWebAssember.toConfigDomainList(confs);
    }

    public void updateConfiguration(String confKey, String confValue) {
        configDao.updateConfiguration(confKey, confValue);
    }

    public List<SubDBConf> obtainAllSubDBConfs() {
        List<Map<String, Object>> confs = configDao.loadAllSubDBConfs();
        return ConfigWebAssember.toSubDBConfDomainList(confs);
    }

    public SubDBConf obtainSubDBConfById(int subDBConfId) {
        Map<String, Object> conf = configDao.loadSubDBConfById(subDBConfId);
        return ConfigWebAssember.toSubDBConfDomain(conf);
    }

    public void saveSubDBConf(SubDBConf subDBConf) {
        configDao.updateSubDBConf(subDBConf);
    }
}
