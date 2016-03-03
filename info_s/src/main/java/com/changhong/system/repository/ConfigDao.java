package com.changhong.system.repository;

import com.changhong.system.domain.DBConf;
import com.changhong.system.domain.DBBakHistory;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:16
 */
public interface ConfigDao {

    List<Map<String, Object>> loadAllDbConfs();

    Map<String, Object> loadDbConfById(int dbConfId);

    void updateDbConf(DBConf dbConf);

    List<Map<String, Object>> loadBakUpHistories(int dbConfId);

    void saveBakUpHistory(DBBakHistory history);
}
