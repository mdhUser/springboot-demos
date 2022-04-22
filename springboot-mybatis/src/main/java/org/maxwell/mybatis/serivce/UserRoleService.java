package org.maxwell.mybatis.serivce;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 14:08
 */
public interface UserRoleService {

    /**
     * 添加用户角色
     *
     * @param uid
     * @param rids
     * @return
     */
    int addUserRole(@Param("uid") int uid, @Param("rids") List<Integer> rids);

    /**
     * 按 Uid 删除用户角色
     *
     * @param uid
     * @return
     */
    int deleteUserRoleByUid(int uid);

    /**
     * 通过 Uid 查找 Rids
     *
     * @param uid
     * @return
     */
    List<Integer> findRidsByUid(int uid);


}
