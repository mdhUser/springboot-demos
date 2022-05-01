package org.maxwell.deeplearn.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 16:56
 */
@Data
@Accessors(chain = true)
public class User {

    private int id;
    private LocalDate birthday;
    private String name;

}
