package org.maxwell.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.maxwell.swagger.api.HelloAPi;
import org.maxwell.swagger.pojo.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/6/14 18:10
 */
@RestController
@RequestMapping("/stu")
public class HelloController implements HelloAPi {

    /**
     * 测试无参数接口地址
     * 无参：get  http://ip:port/rootPath/stu/hello
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 测试 queryString 风格的参入参数
     * QueryString(问号传参)：
     * get	http://ip:port/rootPath/stu?num=xxx
     */
    @GetMapping
    public Student modifyStudentNum(@RequestParam("num") String num) {
        return new Student(num, "xiaoming", 10, "parts");
    }

    /**
     * 测试Restful风格的参入参数
     * path(Restful):
     * get	http://ip:port/rootPath/stu/xxxx
     */
    @GetMapping("/{name}")
    public Student modifyStudentName(@PathVariable("name") String name) {
        return new Student("002", name, 10, "parts");
    }

    /**
     * 测试json格式的传入参数
     * 请求体传参(json格式的数据):
     * post http://ip:port/rootPath/stu
     * requestBody：
     * {
     * "xxxxx"："xxxx"
     * }
     */
    @PostMapping
    public Student modifyStudent(@RequestBody Student student) {
        student.setName("modifyName");
        return student;
    }

    /**
     * 测试 queryString 、Restful 和 json 格式的参数
     * put	http://ip:port/rootPath/stu/xxxx?name=xxx
     * requestBody：
     * {
     * "xxxxx"："xxxx"
     * }
     */
    @PutMapping("/{id}")
    public Student modifyStudentBynNum(@PathVariable("id") String id, @RequestParam("name") String name, @RequestBody Student student) {
        student.setName(name);
        student.setStuNo(id);
        return student;
    }

}
