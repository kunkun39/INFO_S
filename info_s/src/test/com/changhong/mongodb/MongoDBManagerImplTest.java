package com.changhong.mongodb;

import com.changhong.common.utils.CHNumberUtils;
import com.changhong.common.utils.CHPagingUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 16-2-26
 * Time: 下午2:08
 */
public class MongoDBManagerImplTest {

    private String host1 = "192.168.75.134";
    private String post1 = "27017";
    private String databaseName1 = "collector";

    private String host2 = "192.168.75.142";
    private String post2 = "27017";
    private String databaseName2 = "collector";

    private MongoDatabase db1;
    private MongoDatabase db2;

    public void init() {
        MongoClient client1 = new MongoClient(host1, Integer.valueOf(post1));
        db1 = client1.getDatabase(databaseName1);

        MongoClient client2 = new MongoClient(host2, Integer.valueOf(post2));
        db2 = client2.getDatabase(databaseName2);
    }

    public void insert(MongoDatabase db, String collectionName, Document document) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertOne(document);
    }

    public void insert(MongoDatabase db, String collectionName, List<? extends Document> documents) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertMany(documents);
    }

    private void initDB() {
        long start = System.currentTimeMillis();
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 500000; i++) {
            int period = CHNumberUtils.generateRandomNumber(48);

            Document document = new Document();
            document.put("year", "2016");
            document.put("period", period);
            documents.add(document);

            if (documents.size() == 100) {
                insert(db1, "start_time", documents);
                documents.clear();
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        long during = end - start;
        System.out.println("mongodb take time " + during);
    }

    private void bakCollections(String collection, String year, MongoDatabase fromDB, MongoDatabase toDB) {
        System.out.println("INFO:start tansfer data----------------------------------------");
        long start = System.currentTimeMillis();
        MongoCollection<Document> fromCollection = fromDB.getCollection(collection);
        String toCollectionName = collection + "_" + year;
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
            System.out.println("INFO:transfer data to bak db with number " + (paging.getCurrentPage() * paging.getMaxItems())) ;
        }

        long toCount = toCollection.count();
        if (count != toCount) {
            System.out.println("ERROR: form db count not equal to to db count");
        } else {
            System.out.println("INFO:start delete data ----------------------------------------");
            fromCollection.deleteMany(filter);
        }

        long end = System.currentTimeMillis();
        long during = end - start;
        System.out.println("INFO:mongodb take time " + during);
    }

    public static void main(String[] agrs) {
        MongoDBManagerImplTest test = new MongoDBManagerImplTest();

        test.init();

//        test.initDB();

        test.bakCollections("start_time", "2015", test.db1, test.db2);
    }
}
