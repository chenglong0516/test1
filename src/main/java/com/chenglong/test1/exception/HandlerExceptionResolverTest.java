package com.chenglong.test1.exception;

/*
全局异常处理类3
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Configuration
public class HandlerExceptionResolverTest implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图的跳转
        if(e instanceof NullPointerException){
            mv.setViewName("error5");
        }
        if(e instanceof ArithmeticException){
            mv.setViewName("error6");
        }
        mv.addObject("error", e.toString());
        return mv;
    }
}
