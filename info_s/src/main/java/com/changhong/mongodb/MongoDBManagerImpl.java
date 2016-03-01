package com.changhong.mongodb;

import com.changhong.common.utils.CHJodaUtils;
import com.changhong.common.utils.CHPagingUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 16-2-18
 * Time: 下午5:06
 */
@Service("mongoDBManager")
public class MongoDBManagerImpl implements MongoDBManager {

    private final static Logger log = LogManager.getLogger(MongoDBManagerImpl.class);

    private final static String YEAR_CLOUMN_KEY = "year";
    private final static String MONTH_CLOUMN_KEY = "month";
    private final static String DAY_CLOUMN_KEY = "day";
    private final static String HOUR_CLOUMN_KEY = "hour";

    private MongoDatabase db;

    public static boolean isMongoDBServerConnect(String host, String port, String dbName) {
        try {
            ServerAddress serverAddress = new ServerAddress(host, Integer.valueOf(port));
            MongoClient client = new MongoClient(serverAddress);
            client.getConnectPoint();
            client.close();
            System.out.println("1");
            return true;
        } catch (Exception e) {
            System.out.println("2");
            return false;
        }
    }

    public void init(Map<String, Object> model) {
        DataStoreConfigure.init(model);

        MongoClient client = new MongoClient(DataStoreConfigure.defaultHost, Integer.valueOf(DataStoreConfigure.defaultHost));
        db = client.getDatabase(DataStoreConfigure.defaultDatabase);
    }

    public boolean backup(String collection, String year, String toHost, String toPort, String toDBName) {
        try {
            log.info("INFO:start tansfer data----------------------------------------");
            MongoCollection<Document> fromCollection = db.getCollection(collection);
            String toCollectionName = collection + "_" + year;

            MongoClient client = new MongoClient(toHost, Integer.valueOf(toPort));
            MongoDatabase toDB = client.getDatabase(toDBName);
            MongoCollection<Document> toCollection = toDB.getCollection(toCollectionName);

            Bson filter = new BasicDBObject("year", year);
            long count = fromCollection.count(filter);

            CHPagingUtils paging = new CHPagingUtils(Long.valueOf(count).intValue());
            int totalPages = paging.getNumPages();

            List<Document> temp = new ArrayList<Document>();
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                paging.setCurrentPage(currentPage + "");

                FindIterable<Document> documents = fromCollection.find(filter).skip(paging.getStartPosition()).limit(paging.getMaxItems());
                temp.clear();
                for (Document document : documents) {
                    temp.add(document);
                }
                insert(toDB, toCollectionName, temp);
                log.info("INFO:transfer data to bak db with number " + (paging.getCurrentPage() * paging.getMaxItems()));
            }

            long toCount = toCollection.count();
            if (count != toCount) {
                log.info("ERROR: form db count not equal to to db count");
            } else {
                log.info("INFO:start delete data ----------------------------------------");
                fromCollection.deleteMany(filter);
            }

            System.out.println("INFO:finish back up data---------------------------------");

        } catch (Exception e) {
            log.error("happen error during back up db");
            return false;
        }
        return true;
    }

    private void insert(MongoDatabase db, String collectionName, List<? extends Document> documents) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertMany(documents);
    }

    /*************************************************数据插入部分******************************************************/

    public void insert(String projectKey, Document document, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn) {
        DateTime current = new DateTime();

        document.put(YEAR_CLOUMN_KEY, CHJodaUtils.toYearString(current));
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

    private void insert(String projectKey, Document document) {
        String year = CHJodaUtils.toYearString(new DateTime());
        String collectionName = projectKey + "_" + year;

        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertOne(document);
    }

    public void insert(String projectKey, List<? extends Document> documents, boolean addMonthColumn, boolean addDayColumn, boolean addHourColumn) {
        DateTime current = new DateTime();

        for (Document document : documents) {
            document.put(YEAR_CLOUMN_KEY, CHJodaUtils.toYearString(current));
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

    private void insert(String projectKey, List<? extends Document> documents) {
        String year = CHJodaUtils.toYearString(new DateTime());
        String collectionName = projectKey + "_" + year;

        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertMany(documents);
    }

    /*************************************************数据查询部分******************************************************/

    public static void main(String[] args) {
        isMongoDBServerConnect("127.0.0.1", "34343", "fefe");
    }
}
