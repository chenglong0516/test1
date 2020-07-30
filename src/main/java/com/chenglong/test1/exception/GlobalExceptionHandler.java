package com.chenglong.test1.exception;

/*
全局异常处理类
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GlobalExceptionHandler {
    //处理异常方法
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("err", e.toString());
        mv.setViewName("error1");
        return mv;
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView ArithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("err", e.toString());
        mv.setViewName("error2");
        return mv;
    }
}
