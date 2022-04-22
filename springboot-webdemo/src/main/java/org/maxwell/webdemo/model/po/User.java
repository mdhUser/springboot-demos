package org.maxwell.webdemo.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private String createTime;
    private String updateTime;
    private String remark;
    private Set<Role> roles = new HashSet<Role>(0);

}
