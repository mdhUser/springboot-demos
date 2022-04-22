package org.maxwell.webdemo.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 13:59
 */
@Data
public class UserVO implements Serializable {

    private Integer id;
    private String username;
    private String email;
    private String createTime;
    private String updateTime;
    private String remark;
    private Set<RoleVO> roles;

}