package org.maxwell.mpanno.controller;

import org.maxwell.mpanno.entity.TbRole;
import org.maxwell.mpanno.entity.bo.RoleQueryBean;
import org.maxwell.mpanno.entity.response.ResponseResult;
import org.maxwell.mpanno.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/22 1:48
 */

@RestController
@RequestMapping("/mp/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/list")
    public ResponseResult<List<TbRole>> list(RoleQueryBean queryBean) {
       return ResponseResult.success(roleService.findList(queryBean));
    }


}
