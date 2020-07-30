package com.chenglong.test1.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.chenglong.test1.entities.Account;
import com.chenglong.test1.exception.BusinessException;
import com.chenglong.test1.mapper.AccountMapper;
import com.chenglong.test1.service.AccountService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * 文件上传类
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/addAccount")
    public String addAccount(@RequestBody @Validated Account account, BindingResult result) throws Exception
    {
        //接收参数校验的错误信息BindingResult
        if(result.hasErrors()){
            StringBuilder errSB = new StringBuilder();
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError err: list){
                FieldError fieldError = (FieldError)err;
                String fieldName = fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                System.out.println(fieldName + "," + msg);
                errSB.append(fieldName + "," + msg);
                errSB.append('\n');
            }
            return errSB.toString();
        }

        try{
            System.out.println("addAccount...");
            System.out.println(account.toString());
            accountService.addAccount(account);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/updateAccount")
    public String updateAccount(@RequestBody Account account) throws Exception
    {
        try{
            System.out.println("updateAccount...");
            System.out.println(account.toString());
            accountService.updateAccount(account);
            return "success";
        }catch (BusinessException e){
            return String.format("msg:%s, code:%s",e.getMsg(),e.getCode());
        }
    }

    @GetMapping("/getAccount/{id}")
    public Account getAccount(@PathVariable("id") String id) throws Exception
    {
        System.out.println("getAccount " + id);
        Account account = accountService.getAccount(id);
        return account;
    }


    @GetMapping("/getAccounts")
    public List<Account> getAccounts() throws Exception
    {
        System.out.println("getAccounts ");
        List<Account> accountList = accountService.getAccounts();
        return accountList;
    }


    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable("id") String id) throws Exception
    {
        try{
            System.out.println("deleteAccount..." + "id");
            accountService.deleteAccount(id);
            return "success";
        }catch (BusinessException e){
            return String.format("msg:%s, code:%s",e.getMsg(),e.getCode());
        }
    }
}
