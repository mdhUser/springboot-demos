package org.maxwell.webdemo.service;

import org.maxwell.webdemo.model.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:21
 */
public interface RoleService {

    List<RoleVO> findRoleList();

}
