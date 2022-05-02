package org.maxwell.webdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.maxwell.webdemo.mapper.RoleMapper;
import org.maxwell.webdemo.model.po.TRole;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, TRole> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<TRole> findRoleList() {
        QueryWrapper<TRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name");
        return roleMapper.selectList(queryWrapper);
    }

}
