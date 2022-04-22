package org.maxwell.mybatisplus.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.maxwell.mybatisplus.entity.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 0:55
 */
@Data
public class UserVO implements BaseEntity {

    private Integer id;
    private String userName;
    private String email;
    private Integer phoneNumber;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private List<RoleVO> roles;

}
