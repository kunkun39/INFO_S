package com.changhong.system.domain;

import com.changhong.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 16-2-22
 * Time: 下午4:18
 */
public class SystemConf extends EntityBase {

    private ConfKey confKey;

    private String confValue;

    public SystemConf(int id, String confKey, String confValue) {
        setId(id);
        this.confKey = ConfKey.valueOf(confKey);
        this.confValue = confValue;
    }

    public ConfKey getConfKey() {
        return confKey;
    }

    public void setConfKey(ConfKey confKey) {
        this.confKey = confKey;
    }

    public String getConfValue() {
        return confValue;
    }

    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }
}
