package com.changhong.common.thread;

import com.changhong.mongodb.MongoDBManager;
import org.bson.Document;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: pengjie
 * Date: 2016/3/8
 * Time: 10:52
 */
public class DataProcessor extends Thread{

    private LinkedBlockingQueue<Object> queue;

    private MongoDBManager mongoDBManager;

    private boolean isRunning;

    public DataProcessor(LinkedBlockingQueue<Object> queue, MongoDBManager mongoDBManager) {
        this.queue = queue;
        this.mongoDBManager = mongoDBManager;
        if (mongoDBManager != null) {
            isRunning = true;
        }
    }

    @Override
    public void run() {
        while(isRunning)
        {
            process();
        }
    }

    public void stopProcess() {
        isRunning = false;
    }

    private void process() {
        Map<String, Object> map = null;
        List<Map<String, Object>> list = null;
        try {
            Object obj = queue.poll(100, TimeUnit.MILLISECONDS);
            if (obj instanceof Map) {
                map = (Map<String, Object>) obj;
                //insert(mongoDBManager, map);
            } else  if (obj instanceof List){
                list = (List<Map<String, Object>>) obj;
                //insert(mongoDBManager, list);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void insert(MongoDBManager mongoDBManager, Map<String, Object> map) {
        String projectName = (String) map.get("projectName");
        if (StringUtils.hasText(projectName)) {
            map.remove("projectName");
            mongoDBManager.insert(projectName, new Document(map), false, false, false);
        }
    }

    private void insert(MongoDBManager mongoDBManager, List<Map<String, Object>> list) {
        String projectName = (String) list.get(0).get("projectName");
        if (StringUtils.hasText(projectName)) {
            List<Document> documents = new ArrayList<Document>();
            for (Map<String, Object> map : list) {
                map.remove("projectName");
                documents.add(new Document(map));
            }
            mongoDBManager.insert(projectName, documents, false, false, false);
        }
    }
}
