package com.changhong.mongodb;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-18
 * Time: 下午4:56
 */
public class DataStoreConfigure {

    //default mongodb configure if no other configuration input
    public static String defaultHost = "127.0.0.1";
    public static String defaultPort = "27017";
    public static String defaultDatabase = "info_co";

    //collections mapping such as projectkey_2013 -> 192.168.0.2:27017
    public static Map<String, String> databaseMappings = new HashMap<String, String>();

    public static void init(Map<String, Object> model) {
        if (model != null) {
            defaultHost = (String) model.get("DEFAULT_HOST");
            defaultPort = (String) model.get("DEFAULT_PORT");
            defaultDatabase = (String) model.get("DEFAULT_DATABASE");
        }
    }
}
