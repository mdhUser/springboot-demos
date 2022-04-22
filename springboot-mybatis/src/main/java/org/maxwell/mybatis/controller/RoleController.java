package org.maxwell.mybatis.controller;

import org.maxwell.mybatis.entity.model.RolesUserPerVO;
import org.maxwell.mybatis.entity.response.ResponseResult;
import org.maxwell.mybatis.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/1 23:58
 */
@RequestMapping("/test/mybatis/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/find_roles_up")
    public ResponseResult<List<RolesUserPerVO>> finRolesUP() {
        List<RolesUserPerVO> rolesWithUserAndPermission = roleService.findRolesWithUserAndPermission();
        return ResponseResult.success(rolesWithUserAndPermission);
    }


}