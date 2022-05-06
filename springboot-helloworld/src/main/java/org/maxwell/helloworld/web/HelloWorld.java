package org.maxwell.helloworld.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/5 23:15
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {


    @GetMapping
    public Object hello(String name) {
        return "Hello" + name;
    }


}
