package com.chenglong.test1.exception;

/*
全局异常处理类2

 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

//@Configuration
public class SimpleMappingExceptionResolverTest {

    /*
        此方法返回值必须是SimpleMappingExceptionResolver
     */
//    @Bean
    public SimpleMappingExceptionResolver getSmer(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        //定义映射关系 异常类型全面，视图名称
        Properties properties = new Properties();
        properties.put("java.lang.NullPointerException", "error3");
        properties.put("java.lang.ArithmeticException", "error4");

        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
