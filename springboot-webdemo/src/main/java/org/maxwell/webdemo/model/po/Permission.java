package org.maxwell.webdemo.model.po;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Permission{

    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 权限关键字，用于权限控制
     */
    private String keyword;
    /**
     *  描述
     */
    private String description;
    /**
     *
     */
    private Set<Role> roles = new HashSet<Role>(0);

}
