package com.changhong.system.domain;

import com.changhong.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 16-2-25
 * Time: 下午5:16
 */
public class SubDBConf extends EntityBase {

    private String host;

    private String port;

    private String dbName;

    public SubDBConf() {
        setId(-1);
    }

    public SubDBConf(int id, String host, String port, String dbName) {
        setId(id);
        this.host = host;
        this.port = port;
        this.dbName = dbName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
