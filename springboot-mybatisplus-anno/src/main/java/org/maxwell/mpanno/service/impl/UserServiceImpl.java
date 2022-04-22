package org.maxwell.mpanno.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.maxwell.mpanno.entity.TbUser;
import org.maxwell.mpanno.entity.bo.UserQueryBean;
import org.maxwell.mpanno.mapper.UserMapper;
import org.maxwell.mpanno.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, TbUser> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<TbUser> findUserList(UserQueryBean queryBean) {
        return userMapper.findList(queryBean);
    }

}
