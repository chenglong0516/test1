package com.chenglong.test1.config;

import com.chenglong.test1.listener.SecondListener;
import com.chenglong.test1.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置servlet
 */

@Configuration
public class ListenerConfig {

    /*
        完成Listener注册
     */
    @Bean
    public ServletListenerRegistrationBean getListener(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }
}
