package com.changhong.system.service;

import com.changhong.mongodb.MongoDBManager;
import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;
import com.changhong.system.repository.ConfigDao;
import com.changhong.system.service.assember.ConfigWebAssember;
import org.joda.time.DateTime;
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
    private MongoDBManager mongoDBManager;

    @Autowired
    private ConfigDao configDao;

    //    Sub DB

    public List<DBConf> obtainAllDbConfs() {
        List<Map<String, Object>> confs = configDao.loadAllDbConfs();
        return ConfigWebAssember.toDbConfDomainList(confs);
    }

    public DBConf obtainDbConfById(int dbConfId) {
        Map<String, Object> conf = configDao.loadDbConfById(dbConfId);
        return ConfigWebAssember.toDbConfDomain(conf);
    }

    public void saveDbConf(DBConf dbConf) {
        configDao.updateDbConf(dbConf);
    }

    //    Bak Up History

    public List<DBBakHistory> obtainBakUpHistories(int dbConfId) {
        List<Map<String, Object>> histories = configDao.loadBakUpHistories(dbConfId);
        return ConfigWebAssember.toDbBakHistoryDomainList(histories);
    }

    public void saveBakUpDbHistory(DBBakHistory history) {
        DBConf dbConf = obtainDbConfById(history.getDbConfId());

        String year = history.getProjectCode();
        String fromCollection = history.getProjectCode();

        mongoDBManager.backup(fromCollection, year, dbConf.getHost(), dbConf.getPort(), dbConf.getDbName());

        history.setActionTime(new DateTime());
        configDao.saveBakUpHistory(history);

    }
}
