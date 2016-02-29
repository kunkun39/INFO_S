package com.changhong.system.repository;

import com.changhong.common.utils.CHStringUtils;

/**
 * User: Jack Wang
 * Date: 16-2-24
 * Time: 上午10:11
 */
public class Movie {

    private int id;

    private String logo;

    private String source;

    private String name;

    private int start = 8;

    public Movie(int id, int categoryId, int subCategoryId) {
        this.logo = categoryId + "_" + subCategoryId + "_" + id + ".png";
        this.source = categoryId + "_" + subCategoryId + "_" + id + ".flv";
        this.name = "测试影片";
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
