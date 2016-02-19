package com.changhong.mysql;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午1:27
 */
public class BasicIbatisDataManager extends SqlMapClientDaoSupport {

    @Resource(name = "sqlMapClient")
    protected SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient() {
        super.setSqlMapClient(sqlMapClient);
    }
}
