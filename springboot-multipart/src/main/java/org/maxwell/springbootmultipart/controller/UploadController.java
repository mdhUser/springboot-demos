package org.maxwell.springbootmultipart.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 20:47
 */

@RestController
@RequestMapping("/upload")
public class UploadController {


    @PostMapping
    public String upload(@RequestParam MultipartFile file) throws IOException {

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //表单输入框中的名称
        String name = "=="+file.getName()+"==";
        System.out.println(name);
        //获取后缀名
        assert originalFilename != null;
        String sufixType = originalFilename.substring(originalFilename.lastIndexOf("."));

        //保存
        File f = new File("D:/down/");
        if (!f.exists()){
            f.mkdir();
        }
        String localFile = "D:/down/" + System.currentTimeMillis() + sufixType;
        file.transferTo(new File(localFile));

        return "success";
    }


}
