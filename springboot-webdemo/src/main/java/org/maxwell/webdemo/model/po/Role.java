package org.maxwell.webdemo.model.po;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class Role {

    private String id;
    private String name;
    private String keyword;
    private String description;
    private Set<User> users = new HashSet<User>(0);
    private Set<Permission> permissions = new HashSet<Permission>(0);

}
