package com.chenglong.test1;

import com.chenglong.test1.config.Account1;
import com.chenglong.test1.config.AppConfig;
import com.chenglong.test1.entities.Account;
import com.chenglong.test1.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/*
junit5 的测试类
 */
@SpringBootTest(classes = Test1Application.class)
class Test1ApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
        List<Account> accountList = this.accountService.getAccounts();
        System.out.println(accountList);
    }

    /*
    获取IoC容器中的Bean
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Account1 bean = ctx.getBean(Account1.class);
        System.out.println(bean.toString());
    }

}
