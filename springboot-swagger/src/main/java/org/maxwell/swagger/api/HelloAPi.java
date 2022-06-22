package org.maxwell.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.maxwell.swagger.pojo.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/6/14 19:22
 */
@Api(tags = "测试Controller", description = "Hello测试 Swagger Controller 注解")
public interface HelloAPi {

    @ApiOperation("测试 Hello 方法")
    @GetMapping("/hello")
     String hello();


    @GetMapping
    @ApiOperation("问号传参")
    @ApiImplicitParam(name = "num", value = "学成的编号", required = true, dataType = "String", paramType = "query")
    Student modifyStudentNum(@RequestParam("num") String num);


    @GetMapping("/{name}")
    @ApiOperation("restful风格传参")
    Student modifyStudentName(@PathVariable("name") String name);


    @PostMapping
    @ApiOperation("请求体JSON传参方法")
     Student modifyStudent(@RequestBody Student student);


    @PutMapping("/{id}")
    @ApiOperation("综合传参方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学成的编号", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "学成的名称", required = true, dataType = "String", paramType = "query")
    })
     Student modifyStudentBynNum(@PathVariable("id") String id, @RequestParam("name") String name, @RequestBody Student student);



}
