package org.maxwell.mybatis.serivce.impl;
import org.maxwell.mybatis.entity.model.RolesUserPerVO;
import org.maxwell.mybatis.mapper.RoleMapper;
import org.maxwell.mybatis.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 23:57
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RolesUserPerVO> findRolesWithUserAndPermission() {
        return roleMapper.findRolesWithUserAndPermission();
    }


}
