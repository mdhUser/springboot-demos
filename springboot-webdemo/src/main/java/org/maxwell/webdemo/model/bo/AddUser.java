package org.maxwell.webdemo.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 对应前端发送添加用户数据的JavaBean
 */
@Data
public class AddUser implements Serializable {
    /**
     *  id
     */
    private Integer id;
    /**
     *  用户名
     */
    private String username;
    /**
     *  密码
     */
    private String password;
    /**
     *  邮箱
     */
    private String email;
    /**
     *  备注
     */
    private String remark;
    /**
     * 角色 ID
     */
    private List<Integer> roleIds;

}
