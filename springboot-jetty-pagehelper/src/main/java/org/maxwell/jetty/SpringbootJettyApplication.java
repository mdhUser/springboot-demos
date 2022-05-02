package org.maxwell.jetty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.maxwell.jetty.mapper")
public class SpringbootJettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJettyApplication.class, args);
    }

}
