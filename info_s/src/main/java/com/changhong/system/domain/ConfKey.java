package com.changhong.system.domain;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午4:22
 */
public enum ConfKey {

    MO_DB_HOST("MongoDB数据库Host"),
    MO_DB_PORT("MongoDB数据库Port"),
    MO_DB_NAME("MongoDB数据库Name");

    private String description;

    ConfKey(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name();
    }
}
