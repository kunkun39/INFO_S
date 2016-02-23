package com.changhong.system.repository;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-11-20
 * Time: 上午8:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class ConfigDaoImpTest extends TestCase {

    @Resource
    ConfigDao configDao;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSingle() {
        configDao.updateConfiguration("MO_DB_HOST", "192.168.01.135");
    }

    @Test
    public void testLoadJson() {
        //解析数据
        String deviceFile = "D:\\ChangHong\\SCN_Column.json";
        StringBuilder builder = new StringBuilder();

        File file = new File(deviceFile);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = "";
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(builder.toString().replace(" ", ""));

    }

}
