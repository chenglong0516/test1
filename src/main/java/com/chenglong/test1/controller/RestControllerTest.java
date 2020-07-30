package com.chenglong.test1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传类
 */
@RestController
public class RestControllerTest {

    @GetMapping("/restMethod/{id}")
    public String restMethod1(@PathVariable(name = "id") String theId) throws Exception
    {
        System.out.println("id = " + theId);
        return "ok";
    }

    /**
     * RestFul 风格请求，必须使用PathVariable加形参来标注参数
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping("/restMethod/{id}/{name}")
    public String restMethod2(@PathVariable("id") String id, @PathVariable("name") String name) throws Exception
    {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "ok";
    }
}
