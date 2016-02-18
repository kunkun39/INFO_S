package com.changhong.system.repository;

import com.changhong.common.utils.AppInfoUtils;
import com.changhong.common.utils.NumberUtils;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * User: Jack Wang
 * Date: 14-4-29
 * Time: 下午4:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class StatisticDaoImplTest extends TestCase {
    @Resource
    SessionFactory sessionFactory;

    HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @After
    public void tearDown() {
        hibernateTemplate = null;
    }

}
