package org.maxwell.webdemo.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  更新用户
 */
@Data
public class UpdateUser implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     *  密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     *  评论
     */
    private String remark;
    /**
     *  角色id
     */
    private List<Integer> roleIds;

}
