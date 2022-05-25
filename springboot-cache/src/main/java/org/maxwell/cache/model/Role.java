package org.maxwell.cache.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName role
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String roleName;
    /**

     *
     */
    private String roleCode;

    /**
     * 
     */
    private String introduce;

    private static final long serialVersionUID = 1L;
}