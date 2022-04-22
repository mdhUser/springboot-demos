package org.maxwell.webdemo.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:17
 */
@Data
public class RoleVO implements Serializable {

    private String id;
    private String name;
    private String description;

}
