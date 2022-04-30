package org.maxwell.autoconfg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 17:47
 */
@Data
@Component
@ConfigurationProperties(prefix = "mybean")
public class MyBean {

    private String name;

    private int age;

}
