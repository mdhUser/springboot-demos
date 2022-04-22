package org.maxwell.webdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.maxwell.webdemo.model.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:24
 */

public interface RoleMapper {

    @Select("select id,name from t_role")
    List<RoleVO> findRoleList();
}
