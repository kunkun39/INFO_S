package com.changhong.system.web;

import com.changhong.common.items.InfoGaterManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContextListener;

/**
 * User: Jack Wang
 * Date: 15-8-10
 * Time: 上午11:18
 */
public class CHSessionListener implements HttpSessionListener, ServletContextListener {

    private final static Logger log = LogManager.getLogger(CHSessionListener.class);


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        InfoGaterManager infoGaterManager = new InfoGaterManager();
//        infoGaterManager.loadConfig();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e);
        }
        log.warn("Shut down the server and shut down the schedular!");
    }

    public void sessionCreated(HttpSessionEvent event) {
    }

    @SuppressWarnings("unchecked")
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}
