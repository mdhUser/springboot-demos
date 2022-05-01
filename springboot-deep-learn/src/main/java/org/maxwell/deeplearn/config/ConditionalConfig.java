package org.maxwell.deeplearn.config;

import org.maxwell.deeplearn.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 22:57
 */
//@ConditionalOnClass(User.class) //【1】User类存在，那么当前的配置bean就会被加载到ioc容器下
//@ConditionalOnMissingBean(User.class) //【3】当指定类型的bean在ioc容器中不存在，那么生效
@ConditionalOnMissingClass("org.maxwell.deeplearn.entity.Test") //@ConditionalOnMissingClass(value = {"com.itheima.pojo.User"})
/**
 * 配合文件必须配置myredis.enable=true才能被创建
 */
@ConditionalOnProperty(prefix = "myredis",name = "enable",havingValue = "true")
public class ConditionalConfig {

    @Bean
    public User user() {
        return new User()
                .setId(1)
                .setBirthday(LocalDate.of(1999, 5, 11))
                .setName("Maxwell");
    }

}
