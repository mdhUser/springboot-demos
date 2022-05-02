package org.maxwell.webdemo.model.po;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class TRole {

    private String id;
    private String name;
    private String keyword;
    private String description;
    private Set<TUser> users = new HashSet<TUser>(0);
    private Set<TPermission> permissions = new HashSet<TPermission>(0);

}
