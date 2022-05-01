package org.maxwell.ymlprofiles.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 14:56
 */
@Data
@Component
@ConfigurationProperties(prefix = "company")
public class Company {

    private String name;

    private String address;

}
