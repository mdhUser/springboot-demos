package org.maxwell.mybatis.entity.model;

import lombok.Data;
import org.maxwell.mybatis.entity.TRole;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 18:54
 */
@Data
public class UserRoleVO {

    private Integer id;
    private String username;
    private String password;
    private String remark;
    private String email;
    private Date createTime;
    private Date updateTime;
    private List<TRole> tRoles;
}
