package org.maxwell.webdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.maxwell.webdemo.advice.error.BusinessException;
import org.maxwell.webdemo.mapper.UserMapper;
import org.maxwell.webdemo.mapper.UserRoleMapper;
import org.maxwell.webdemo.model.bo.AddUser;
import org.maxwell.webdemo.model.bo.UpdateUser;
import org.maxwell.webdemo.model.dto.PageDTO;
import org.maxwell.webdemo.model.po.TUser;
import org.maxwell.webdemo.model.vo.UserVO;
import org.maxwell.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.maxwell.webdemo.constant.ResponseStatus.UPDATE_ERROR;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 12:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public PageDTO<UserVO> findUserList(int pageSize, int currentPage, String name) {
        int records = userMapper.findTotalRecords();
        int offset = (currentPage - 1) * pageSize;
        List<UserVO> userList = userMapper.findUserListLike(offset, pageSize, name);
        return new PageDTO<>(currentPage, pageSize, records, userList);
    }


    @Transactional(rollbackFor = BusinessException.class)
    public int addUser(AddUser user) {
        int row = userMapper.addUser(user);
        if (row > 0) {
            userRoleMapper.addUserRoles(user.getId(), user.getRoleIds());
        }
        return row;
    }


    @Transactional(rollbackFor = BusinessException.class)
    public int updateUser(UpdateUser user) {
        List<Integer> ids = userRoleMapper.findRoles(user.getId());
        List<Integer> roleIds = user.getRoleIds();
        Collections.sort(roleIds);
        Collections.sort(ids);
        if (!ids.equals(roleIds)){
            userRoleMapper.deleteRecords(user.getId());
            int row = userRoleMapper.addUserRoles(user.getId(), user.getRoleIds());
            if (row < 1) {
                throw new BusinessException(UPDATE_ERROR.getCode(), UPDATE_ERROR.getDescription());
            }
        }
        return userMapper.updateUser(user);
    }

    @Transactional(rollbackFor = BusinessException.class)
    public int deleteUser(int uid) {
        if (userRoleMapper.findRoles(uid).size() > 0)
            userRoleMapper.deleteRecords(uid);
        return userMapper.deleteUser(uid);
    }

}
