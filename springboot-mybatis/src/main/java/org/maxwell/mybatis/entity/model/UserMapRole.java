package org.maxwell.mybatis.entity.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 18:17
 */
@Data
public class UserMapRole {

    private Integer id;
    private String username;
    private String password;
    private String remark;
    private String email;
    private Date createTime;
    private Date updateTime;
    private List<Integer> rids;

}
