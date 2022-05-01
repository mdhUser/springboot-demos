package org.maxwell.deeplearn;

import org.maxwell.deeplearn.config.MyImportBeanDefinitionRegister;
import org.maxwell.deeplearn.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

//@Import(MyConfig.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegister.class)
@SpringBootApplication
public class SpringbootDeepLearnApplication {

    public static void main(String[] args) {

        //获取上下文环境
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootDeepLearnApplication.class, args);

        User user = context.getBean("user", User.class);
        System.out.println(user);


    }

}
