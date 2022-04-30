package org.maxwell.autoconfg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 17:58
 */

@Configuration
public class MyBeanAutoConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }

}
