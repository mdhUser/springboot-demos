package org.maxwell.webdemo.model.po;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TUser {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String createTime;
    private String updateTime;
    private String remark;
    private Set<TRole> roles = new HashSet<TRole>(0);

}
