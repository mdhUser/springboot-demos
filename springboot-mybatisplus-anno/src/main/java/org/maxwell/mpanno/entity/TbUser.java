package org.maxwell.mpanno.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TbUser implements BaseEntity{

    private Integer id;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private Integer phoneNumber;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private List<TbRole> roles;


}
