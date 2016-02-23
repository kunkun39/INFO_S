package com.changhong.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:12
 */
public class EntityBase implements Serializable {

    private int id;

    protected EntityBase() {
    }

    /**
     * *******************************************************GETTER/SETTER****************************************
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
