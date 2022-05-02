package org.maxwell.webdemo.controller;

import org.maxwell.webdemo.model.po.TRole;
import org.maxwell.webdemo.model.vo.RoleVO;
import org.maxwell.webdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:12
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roleList")
    public List<TRole> roleList() {
        return roleService.findRoleList();
    }

}
