package com.chenglong.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问resources/static/里面的静态资源 hengtian.html
 */
@Controller
public class ShowErrorController {

    @RequestMapping("/showHengtian")
    public String showHengtian(){
        return "hengtian.html";
    }

    @RequestMapping("/testError1")
    public String testError(){
        String str = null;
        str.length();
        return "";
    }

    @RequestMapping("/testError2")
    public String testError1(){
        int a = 10/0;
        return "";
    }
    //处理异常方法
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView nullPointerExceptionHandler(Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("err", e.toString());
//        mv.setViewName("error1");
//        return mv;
//    }
}
