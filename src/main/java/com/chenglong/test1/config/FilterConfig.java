package com.chenglong.test1.config;

import com.chenglong.test1.filter.SecondFilter;
import com.chenglong.test1.servlet.SecondServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置filter
 */

@Configuration
public class FilterConfig {

    /*
        完成Filter注册
     */
    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//        bean.addUrlPatterns("/*");
        return bean;
    }
}
