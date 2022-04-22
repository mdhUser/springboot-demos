package org.maxwell.webdemo.service.impl;

import org.maxwell.webdemo.mapper.RoleMapper;
import org.maxwell.webdemo.model.vo.RoleVO;
import org.maxwell.webdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:22
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleVO> findRoleList() {
        return roleMapper.findRoleList();
    }

}
