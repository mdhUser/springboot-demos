package org.maxwell.mybatis.serivce.impl;

import org.maxwell.mybatis.entity.model.UserMapRole;
import org.maxwell.mybatis.entity.model.UserPermissionVO;
import org.maxwell.mybatis.entity.model.UserRoleVO;
import org.maxwell.mybatis.mapper.TUserMapper;
import org.maxwell.mybatis.mapper.TUserRoleMapper;
import org.maxwell.mybatis.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 14:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleVO> findUserRolesLimit(int index, int count) {
        return userMapper.findUserRolesLimit(index, count);
    }

    @Override
    public int addUser(UserMapRole user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(UserMapRole tUser) {
        int row = userMapper.updateUser(tUser);
        return row > 0 ? row : -1;
    }

    @Override
    public int deleteUserByUid(int uid) {
        int result = userRoleMapper.deleteUserRoleByUid(uid);
        if (result==0) {
            return -1;
        }
        return userMapper.deleteUserByUid(uid);
    }

    @Override
    public List<UserPermissionVO> findUserPermissionLimit(int from, int total) {
        return userMapper.findUserPermissionLimit(from, total);
    }

    @Override
    public UserPermissionVO findUserPermissionByUid(int uid) {
        return userMapper.findUserPermissionByUid(uid);
    }

    @Override
    public int updateUserAndRoles(UserMapRole userMapRole) {
        int row = userMapper.updateUser(userMapRole);
        if (row > 0) {
            userRoleMapper.deleteUserRoleByUid(userMapRole.getId());
            return userRoleMapper.addUserRole(userMapRole.getId(), userMapRole.getRids());
        }
        return row;
    }
}