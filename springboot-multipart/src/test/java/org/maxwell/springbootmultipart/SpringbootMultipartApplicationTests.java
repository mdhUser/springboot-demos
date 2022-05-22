package org.maxwell.springbootmultipart;

import org.junit.jupiter.api.Test;
import org.maxwell.autoconfg.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMultipartApplicationTests {


    @Autowired
    private MyBean myBean;

    @Test
    void contextLoads() {

        System.out.println(myBean);

    }

}
