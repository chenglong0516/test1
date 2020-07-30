package com.chenglong.test1.config;

import com.chenglong.test1.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置servlet
 */

@Configuration
public class ServletConfig {

    /*
        完成servlet注册
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/SecondServlet");
        return bean;
    }
}
