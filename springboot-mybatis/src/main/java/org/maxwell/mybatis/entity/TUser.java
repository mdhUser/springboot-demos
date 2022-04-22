package org.maxwell.mybatis.entity;

import lombok.Data;

import java.util.Date;


@Data
public class TUser {

  private Integer id;
  private String username;
  private String password;
  private String remark;
  private String email;
  private Date createTime;
  private Date updateTime;

  public TUser() {
  }

  public TUser(String username, String password, String remark, String email, Date createTime, Date updateTime) {
    this.username = username;
    this.password = password;
    this.remark = remark;
    this.email = email;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
