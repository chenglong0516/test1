package com.chenglong.test1.config;

import com.chenglong.test1.entities.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan //会扫描当前包及其子包中的Component注解的对象到IOC容器中
public class AppConfig {
//    @Bean(name = "account")
//    public Account initAccount(){
//        Account account = new Account();
//        account.setId(1);
//        account.setMoney(100.0);
//        account.setName("aaa");
//        return account;
//    }
}
