package org.maxwell.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan("org.maxwell.webdemo.mapper")
public class SpringbootWebdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebdemoApplication.class, args);
    }

}
