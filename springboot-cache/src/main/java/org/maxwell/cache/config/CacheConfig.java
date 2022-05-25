package org.maxwell.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author itheima
 * code 自定义KeyGenerator生成策略
 */
@Configuration
public class CacheConfig {

    /**
     * 可通过引用myKeyGenerator使用公共的key生成器
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return (o,method,objects)->method.getName()+ "["+Arrays.asList(objects).toString()+"]";
    }
}
