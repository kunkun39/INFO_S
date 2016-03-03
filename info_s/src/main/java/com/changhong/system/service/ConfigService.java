package com.changhong.system.service;

import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午5:45
 */
public interface ConfigService {

//   DB

    List<DBConf> obtainAllDbConfs();

    DBConf obtainDbConfById(int dbConfId);

    void saveDbConf(DBConf dbConf);

//    Bak Up History

    List<DBBakHistory> obtainBakUpHistories(int dbConfId);

    void saveBakUpDbHistory(DBBakHistory history);
}
