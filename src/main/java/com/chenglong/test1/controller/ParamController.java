package com.chenglong.test1.controller;

import com.chenglong.test1.entities.Account;
import com.chenglong.test1.exception.BusinessException;
import com.chenglong.test1.service.AccountService;
import com.mysql.fabric.xmlrpc.base.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文件上传类
 */
@Controller
public class ParamController {

    private final static Logger logger = LoggerFactory.getLogger(ParamController.class);
    @GetMapping("/testParam")
    public String testParam(HttpServletRequest request) throws Exception
    {
        logger.info("testParam, param:{}", request.getParameter("id"));
        logger.info("testParam, param:{}", request.getParameter("name"));
        logger.info("testParam, param:{}", request.getParameter("sex"));
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("sex"));
        return "success";
    }

    @GetMapping("/testParam/{id}/{sex}")
    public String testParamRest(@PathVariable String id, @PathVariable String sex) throws Exception
    {
        System.out.println(id);
        System.out.println(sex);

        return "success";
    }
}
