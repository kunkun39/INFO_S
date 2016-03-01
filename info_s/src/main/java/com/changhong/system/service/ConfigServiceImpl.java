package com.changhong.system.service;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.mongodb.MongoDBManager;
import com.changhong.system.domain.SubDBBakHistory;
import com.changhong.system.domain.SubDBConf;
import com.changhong.system.domain.SystemConf;
import com.changhong.system.repository.ConfigDao;
import com.changhong.system.service.assember.ConfigWebAssember;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private MongoDBManager mongoDBManager;

    @Autowired
    private ConfigDao configDao;

    //    Main DB

    public List<SystemConf> obtainAllConfigurations() {
        List<Map<String, Object>> confs = configDao.loadAllConfigurations();
        return ConfigWebAssember.toConfigDomainList(confs);
    }

    public void updateConfiguration(String confKey, String confValue) {
        configDao.updateConfiguration(confKey, confValue);
    }

    //    Sub DB

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

    //    Bak Up History

    public List<SubDBBakHistory> obtainBakUpHistories(int subDBConfId) {
        List<Map<String, Object>> histories = configDao.loadBakUpHistories(subDBConfId);
        return ConfigWebAssember.toSubDBBakHistoryDomainList(histories);
    }

    public void saveBakUpDBHistory(SubDBBakHistory history) {
        SubDBConf subDBConf = obtainSubDBConfById(history.getSubDBConfId());

        String year = history.getProjectCode();
        String fromCollection = history.getProjectCode();

//        mongoDBManager.backup(fromCollection, year, subDBConf.getHost(), subDBConf.getPort(), subDBConf.getDbName());

        history.setActionTime(new DateTime());
        configDao.saveBakUpHistory(history);

    }
}
