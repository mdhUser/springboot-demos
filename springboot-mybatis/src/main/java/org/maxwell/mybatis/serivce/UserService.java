package org.maxwell.mybatis.serivce;

import org.apache.ibatis.annotations.Param;
import org.maxwell.mybatis.entity.model.UserMapRole;
import org.maxwell.mybatis.entity.model.UserPermissionVO;
import org.maxwell.mybatis.entity.model.UserRoleVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 13:59
 */
public interface UserService {


    /**
     * 查找用户限制条数
     *
     * @param index
     * @param count
     * @return
     */
    List<UserRoleVO> findUserRolesLimit(@Param("index") int index, @Param("count") int count);

    /**
     * 用户新增
     *
     * @param user
     * @return
     */
    int addUser(UserMapRole user);

    /**
     * 修改用户
     *
     * @param tUser
     * @return
     */
    int updateUser(UserMapRole tUser);


    /**
     * 按 Uid 删除用户
     *
     * @param uid
     * @return
     */
    int deleteUserByUid(int uid);


    /**
     * 查找用户权限条数
     *
     * @param from
     * @param total
     * @return
     */
    List<UserPermissionVO> findUserPermissionLimit(@Param("from") int from, @Param("total") int total);


    /**
     *  通过 Uid 查找用户权限
     * @param uid
     * @return
     */
    UserPermissionVO findUserPermissionByUid(int uid);

    /**
     *  更新用户和角色
     * @param userMapRole
     * @return
     */
    int updateUserAndRoles(UserMapRole userMapRole);
}
