package org.maxwell.springbootannotations.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 19:15
 */

@Getter
@Configuration
@PropertySource("classpath:wx.properties")
public class WxConfig {

    @Value("${wx.id}")
    private String id;

    @Value("${wx.name}")
    private String name;

    @Value("${wx.password}")
    private String password;


}
