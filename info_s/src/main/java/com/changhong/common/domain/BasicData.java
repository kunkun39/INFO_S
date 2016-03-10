package com.changhong.common.domain;

import java.util.ArrayList;
import java.util.List;
/**
 * User: pengjie
 * Date: 2016/3/9
 * Time: 11:28
 */
public class BasicData {
    public static final String PROJECT_CODE = "projectCode";

    private static List<String> basicDataList;

    static{
        basicDataList = new ArrayList<String>();
        basicDataList.add("mac");
    }

    public static List<String> getBasicDataList() {
        return basicDataList;
    }
}
