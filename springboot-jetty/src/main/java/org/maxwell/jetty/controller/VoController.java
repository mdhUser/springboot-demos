package org.maxwell.jetty.controller;

import org.maxwell.jetty.entity.vo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 11:18
 */
@RestController
@RequestMapping("/enter")
public class VoController {

    @Autowired
    private Enterprise enterprise;

    @GetMapping
    public Object get(){
        return enterprise;
    }


}
