package org.maxwell.deeplearn.config;

import org.maxwell.deeplearn.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

/**
 * @description: proxyBeanMethods = false:方法不会被代理 LITE模式 【多例模式】
 *                proxyBeanMethods = true(默认):方法会被cglib代理 FULL模式 【单例模式】
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 16:55
 */
@Configuration
public class MyConfig {

    @Bean
    public User user() {
        return new User()
                .setId(1)
                .setBirthday(LocalDate.of(1999, 5, 11))
                .setName("Maxwell");
    }


}
