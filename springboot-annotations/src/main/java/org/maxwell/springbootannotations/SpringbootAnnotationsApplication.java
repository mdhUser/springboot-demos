package org.maxwell.springbootannotations;

import org.maxwell.springbootannotations.config.WxConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootAnnotationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAnnotationsApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WxConfig.class);
        WxConfig wxConfig = (WxConfig) context.getBean("wxConfig");
        System.out.println(wxConfig.getId());
        System.out.println(wxConfig.getName());
        System.out.println(wxConfig.getPassword());
    }

}
