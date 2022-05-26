package org.maxwell.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/26 10:54
 */
@TableName("tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("user_name")
    private String userName;
    private String password;
    private String name;
    private Integer age;
    @TableField(fill = FieldFill.UPDATE)
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}