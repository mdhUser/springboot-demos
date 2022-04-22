package org.maxwell.mybatisplus.service.impl;

import org.maxwell.mybatisplus.entity.UserPO;
import org.maxwell.mybatisplus.entity.bo.UserBO;
import org.maxwell.mybatisplus.entity.vo.UserVO;
import org.maxwell.mybatisplus.mapper.UserMapper;
import org.maxwell.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 1:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserPO> findUserList(UserBO user) {
        return userMapper.findList(user);
    }

}
