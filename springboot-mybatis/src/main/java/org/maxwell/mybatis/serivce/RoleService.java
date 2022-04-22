package org.maxwell.mybatis.serivce;

import org.maxwell.mybatis.entity.model.RolesUserPerVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 23:56
 */
public interface RoleService {

    /**
     * 查找具有用户和权限的角色
     *
     * @return
     */
    List<RolesUserPerVO> findRolesWithUserAndPermission();


}
