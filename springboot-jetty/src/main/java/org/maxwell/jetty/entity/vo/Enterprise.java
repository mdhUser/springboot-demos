package org.maxwell.jetty.entity.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 10:40
 */

@Data
@Component
@ConfigurationProperties(prefix = "enterprise")
public class Enterprise {

    private String name;
    private Integer age;
    private String tel;
    private String[] subject;

}
