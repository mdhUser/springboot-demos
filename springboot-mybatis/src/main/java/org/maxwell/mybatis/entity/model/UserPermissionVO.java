package org.maxwell.mybatis.entity.model;

import lombok.Data;
import org.maxwell.mybatis.entity.TPermission;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 17:39
 */

@Data
public class UserPermissionVO {

    private Integer id;
    private String username;
    private String password;
    private String remark;
    private String email;
    private Date createTime;
    private Date updateTime;
    private List<TPermission> tPermissions;
}
