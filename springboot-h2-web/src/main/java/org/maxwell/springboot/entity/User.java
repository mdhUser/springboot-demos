package org.maxwell.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/26 12:53
 */
@Entity
@Data
@Table(name = "tb_user")
public class User {

    @Id
    private int userId;
    private String userName;


}
