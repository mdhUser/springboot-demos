package org.maxwell.cache.service;


import org.maxwell.cache.common.CommonResult;
import org.maxwell.cache.model.Role;

/**
 * @author itheima
 * code
 */
public interface IRoleService {
    CommonResult add(Role role);

    Integer delete(Integer id);

    Role update(Role role);

    Role findById(Integer id);

    CommonResult findAllRole();
}
