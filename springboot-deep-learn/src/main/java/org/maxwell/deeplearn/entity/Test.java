package org.maxwell.deeplearn.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 18:29
 */
@Component
public class Test {


    @PostConstruct
    public void init() {
        System.out.println("init --");
    }

}




