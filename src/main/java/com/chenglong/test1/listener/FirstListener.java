package com.chenglong.test1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合listener
 */

//需要在启动类加注解
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("FirstListener contextInitialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
