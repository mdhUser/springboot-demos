package org.maxwell.mpanno.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.maxwell.mpanno.entity.BaseEntity;


import java.util.Date;

@Data
public class RoleVO implements BaseEntity {

    private Integer id;
    private String name;
    private String roleKey;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
