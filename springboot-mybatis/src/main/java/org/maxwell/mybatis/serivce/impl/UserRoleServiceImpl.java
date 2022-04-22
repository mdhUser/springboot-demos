package org.maxwell.mybatis.serivce.impl;
import org.maxwell.mybatis.mapper.TUserRoleMapper;
import org.maxwell.mybatis.serivce.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 14:13
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Override
    public int addUserRole(int uid, List<Integer> rids) {
        return userRoleMapper.addUserRole(uid,rids);
    }

    @Override
    public int deleteUserRoleByUid(int uid) {
        return userRoleMapper.deleteUserRoleByUid(uid);
    }

    @Override
    public List<Integer> findRidsByUid(int uid) {
        return userRoleMapper.findRidsByUid(uid);
    }
}
