package org.maxwell.mybatis.entity.model;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 22:49
 */
@Data
public class RolesUserPerVO {

    private Integer id;
    private String name;
    private String keyword;
    private String description;
    private List<UserPermissionVO> userList;

}
