package org.maxwell.webdemo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 15:32
 */
public interface UserRoleMapper {


    /**
     * 添加用户角色
     *
     * @param id
     * @param roleIds
     * @return
     */
    int addUserRoles(@Param("uid") Integer id, @Param("roleIds") List<Integer> roleIds);

    /**
     * 查找用户角色
     *
     * @param uid
     * @return
     */
    List<Integer> findRoles(Integer uid);


    /**
     * 删除用户角色
     *
     * @param uid
     * @return
     */
    int deleteRecords(Integer uid);
}
