package com.chenglong.test1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@ServletComponentScan //扫描servlet, Filter, Listener并实例化
@MapperScan("com.chenglong.test1.mapper") //接口映射和配置文件
public class Test1Application {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    //设置redis的Key的序列化器
    private void initRedisTemplate() {
        RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }

}
