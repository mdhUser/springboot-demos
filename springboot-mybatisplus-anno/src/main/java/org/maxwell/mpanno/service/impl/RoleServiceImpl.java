package org.maxwell.mpanno.service.impl;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.maxwell.mpanno.entity.TbRole;
import org.maxwell.mpanno.entity.bo.RoleQueryBean;
import org.maxwell.mpanno.mapper.RoleMapper;
import org.maxwell.mpanno.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 23:58
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, TbRole> implements RoleService {


    @Override
    public List<TbRole> findList(RoleQueryBean queryBean) {
        return lambdaQuery().like(StringUtils.isNotEmpty(queryBean.getName()), TbRole::getName, queryBean.getName())
                .like(StringUtils.isNotEmpty(queryBean.getDescription()), TbRole::getDescription, queryBean.getDescription())
                .like(StringUtils.isNotEmpty(queryBean.getRoleKey()), TbRole::getRoleKey, queryBean.getRoleKey())
                .list();
    }
}
