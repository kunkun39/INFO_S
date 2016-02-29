package com.changhong.system.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-24
 * Time: 上午10:06
 */
public class Category {

    private int id;

    private String name;

    private String description;

    private List<SubCategory> subCategories = new ArrayList<SubCategory>();

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
