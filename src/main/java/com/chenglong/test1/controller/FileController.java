package com.chenglong.test1.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传类
 */
@RestController
public class FileController {

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile file) throws Exception
    {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("E:\\workspace\\workspacePractice\\abc\\" + file.getOriginalFilename()));
        return "ok";
    }
}
