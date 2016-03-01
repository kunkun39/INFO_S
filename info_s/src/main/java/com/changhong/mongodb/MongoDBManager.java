package com.changhong.mongodb;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-18
 * Time: 下午4:55
 */
public interface MongoDBManager {

    void init(Map<String, Object> mode);

    boolean backup(String collection, String year, String toHost, String toPort, String toDBName);

    /*************************************************数据插入部分******************************************************/

    void insert(String projectKey, Document document, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn);

    void insert(String projectKey, List<? extends Document> documents, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn);

    /*************************************************数据查询部分******************************************************/
}
