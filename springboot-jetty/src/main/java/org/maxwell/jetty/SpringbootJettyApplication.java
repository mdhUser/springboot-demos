package org.maxwell.jetty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class SpringbootJettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJettyApplication.class, args);
    }

}
