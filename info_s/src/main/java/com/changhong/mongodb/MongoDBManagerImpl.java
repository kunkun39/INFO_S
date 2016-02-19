package com.changhong.mongodb;

import com.changhong.common.utils.CHJodaUtils;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-18
 * Time: 下午5:06
 */
public class MongoDBManagerImpl implements MongoDBManager {

    private final static String MONTH_CLOUMN_KEY = "month";
    private final static String DAY_CLOUMN_KEY = "day";
    private final static String HOUR_CLOUMN_KEY = "hour";

    private MongoDatabase db;

    public void init(Map<String, Object> model) {
        DataStoreConfigure.init(model);

        MongoClient client = new MongoClient(DataStoreConfigure.defaultHost, Integer.valueOf(DataStoreConfigure.defaultHost));
        db = client.getDatabase(DataStoreConfigure.defaultDatabase);
    }

    /*************************************************数据插入部分******************************************************/

    public void insert(String projectKey, Document document) {
        String year = CHJodaUtils.toYearString(new DateTime());
        String collectionName = projectKey + "_" + year;

        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertOne(document);
    }

    public void insert(String projectKey, Document document, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn) {
        DateTime current = new DateTime();
        if (addMonthColumn) {
            document.put(MONTH_CLOUMN_KEY, CHJodaUtils.toMonthString(current));
        }
        if (addDayColumn) {
            document.put(DAY_CLOUMN_KEY, CHJodaUtils.toDayString(current));
        }
        if (addHourColumn) {
            document.put(HOUR_CLOUMN_KEY, CHJodaUtils.toHourString(current));
        }
        insert(projectKey, document);
    }

    public void insert(String projectKey, List<? extends Document> documents) {
        String year = CHJodaUtils.toYearString(new DateTime());
        String collectionName = projectKey + "_" + year;

        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertMany(documents);
    }

    public void insert(String projectKey, List<? extends Document> documents, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn) {
        DateTime current = new DateTime();
        for (Document document : documents) {
            if (addMonthColumn) {
                document.put(MONTH_CLOUMN_KEY, CHJodaUtils.toMonthString(current));
            }
            if (addDayColumn) {
                document.put(DAY_CLOUMN_KEY, CHJodaUtils.toDayString(current));
            }
            if (addHourColumn) {
                document.put(HOUR_CLOUMN_KEY, CHJodaUtils.toHourString(current));
            }
        }

        insert(projectKey, documents);
    }

    /*************************************************数据查询部分******************************************************/
}
