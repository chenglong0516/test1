package com.chenglong.test1.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.chenglong.test1.entities.Account;
import com.chenglong.test1.exception.BusinessException;
import com.chenglong.test1.mapper.AccountMapper;
import com.chenglong.test1.service.AccountService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Redis类
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash(){
        redisTemplate.opsForValue().set("int_key", "1");

        //数据操作
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 3);
        stringRedisTemplate.opsForValue().decrement("int", 2);

        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");

        stringRedisTemplate.opsForHash().putAll("hash", hash);

        //对key是hash的数据进行多次操作
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1");
        hashOps.put("field4", "value4");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList(){
        //插入两个列表
        //左插反序
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
        //右插正序
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");

        //绑定
        BoundListOperations listOps = stringRedisTemplate.boundListOps("list2");
        //从右边弹出一个元素
        Object o = listOps.rightPop();
        listOps.leftPush("v0");

        List range = listOps.range(0, listOps.size() - 2);
        System.out.println(range);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/multi")
    @ResponseBody
    public Map<String, Object> testMulti() {
        redisTemplate.opsForValue().set("key1", "value1");
//        redisTemplate.execute()
        return null;
    }
}
