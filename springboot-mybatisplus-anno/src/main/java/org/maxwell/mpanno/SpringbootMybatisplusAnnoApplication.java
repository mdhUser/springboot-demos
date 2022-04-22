package org.maxwell.mpanno;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.maxwell.mpanno.mapper")
public class SpringbootMybatisplusAnnoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusAnnoApplication.class, args);
    }

}
