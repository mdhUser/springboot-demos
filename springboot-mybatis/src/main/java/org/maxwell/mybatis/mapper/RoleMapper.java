package org.maxwell.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.maxwell.mybatis.entity.model.RolesUserPerVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 16:05
 */
@Mapper
public interface RoleMapper {


    /**
     *  分页查找具有用户和权限的角色
     * @return
     */
    List<RolesUserPerVO> findRolesWithUserAndPermission();

}
