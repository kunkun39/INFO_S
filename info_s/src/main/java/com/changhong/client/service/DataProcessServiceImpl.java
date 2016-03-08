package com.changhong.client.service;

import com.changhong.common.thread.ApplicationThreadPool;
import com.changhong.common.thread.DataProcessor;
import com.changhong.mongodb.MongoDBManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: pengjie
 * Date: 2016/3/8
 * Time: 10:44
 */
@Service("dataProcessService")
public class DataProcessServiceImpl implements  DataProcessService, InitializingBean{

    @Value("${application.dataprocessor.number}")
    private int dataProcessorNum;

    @Autowired
    private MongoDBManager mongoDBManager;

    private DataProcessorManage[] manages;



    @Override
    public void init() {
        if (dataProcessorNum > 0) {
            manages = new DataProcessorManage[dataProcessorNum];
            for (int i = 0; i < dataProcessorNum; i++) {
                manages[i] = new DataProcessorManage(mongoDBManager);
                ApplicationThreadPool.executeThread(manages[i].getDataProcessor());
            }
        }
    }

    @Override
    public boolean insertData(Map<String, Object> map) {
        return insertData((Object) map);
    }

    @Override
    public boolean insertData(List<Map<String, Object>> list) {
        return insertData((Object) list);
    }

    @Override
    public void stop() {
        for (int i = 0; i < 0; i++) {
            manages[i].getDataProcessor().stopProcess();
        }
    }

    private boolean insertData(Object obj) {
        int test = obj.toString().hashCode();
        int index = Math.abs(obj.toString().hashCode()) % dataProcessorNum;
        return manages[index].enQueue(obj);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    class DataProcessorManage{
        private LinkedBlockingQueue<Object> queue;

        private DataProcessor dataProcessor;

        public DataProcessorManage(MongoDBManager mongoDBManager) {
            queue = new LinkedBlockingQueue<Object>();
            dataProcessor = new DataProcessor(queue, mongoDBManager);
        }

        public boolean enQueue(Object obj) {
            int i = 0;
            return queue.add(obj);
        }

        public DataProcessor getDataProcessor() {
            return dataProcessor;
        }
    }
}
