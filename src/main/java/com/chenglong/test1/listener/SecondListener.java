package com.chenglong.test1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合listener
 */

public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("SecondListener contextInitialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
