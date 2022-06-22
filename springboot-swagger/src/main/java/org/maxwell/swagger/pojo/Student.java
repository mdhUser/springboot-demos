package org.maxwell.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/6/14 18:10
 */
@Data
@ApiModel(value = "学员实体类",description = "对学员属性的封装类")
@AllArgsConstructor
public class Student {
    @ApiModelProperty("学员编号")
    private String stuNo;
    @ApiModelProperty("学员名称")
    private String name;
    @ApiModelProperty("学员年龄")
    private int age;
    @ApiModelProperty("学员地址")
    private String address;

}
