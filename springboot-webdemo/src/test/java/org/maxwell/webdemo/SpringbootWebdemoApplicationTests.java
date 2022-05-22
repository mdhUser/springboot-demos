package org.maxwell.webdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringbootWebdemoApplicationTests {

    @Test
    void contextLoads() {

    }


    @Test
    void testLog() {

        log.info("测试一下");
        log.warn("测试一下");
        log.error("测试一下");
        log.debug("测试一下{}","debug");

    }

}
