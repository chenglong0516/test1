package com.chenglong.test1.controller;

import com.chenglong.test1.entities.Account;
import com.chenglong.test1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/*
页面跳转
 */

@Controller
public class PageController {

    @Autowired
    private AccountService accountService;
    /*
    页面跳转方法
     */
    @GetMapping("/show")
    public String showPage(Model model, HttpServletRequest request){
        model.addAttribute("msg", "Thymeleaf 第一个案例");
        model.addAttribute("msg1", null);
        model.addAttribute("date", new Date());
        model.addAttribute("sex", "male");
        model.addAttribute("id", "1");
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("list", accounts);

        Map<String, Account> map1 = new HashMap<>();
        for(Account account : accounts){
            map1.put(account.getName(), account);
        }
        model.addAttribute("map1", map1);

        request.setAttribute("req", "reqValue");
        request.getSession().setAttribute("session", "sessionValue");
        request.getSession().getServletContext().setAttribute("context", "contextValue");

        return "index";
    }

}
