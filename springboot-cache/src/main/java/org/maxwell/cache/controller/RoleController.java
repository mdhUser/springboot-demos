package org.maxwell.cache.controller;


import org.maxwell.cache.common.CommonResult;
import org.maxwell.cache.model.Role;
import org.maxwell.cache.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author itheima
 * code
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/add")
    public CommonResult add(@RequestBody Role role) {
        return roleService.add(role);
    }

    @DeleteMapping("/delete")
    public CommonResult delete(Integer id) {
        Integer count = roleService.delete(id);
        return CommonResult.success(count);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody Role role) {
        Assert.notNull(role.getId(),"Id is not null");
        Role roleResult = roleService.update(role);
        return CommonResult.success(roleResult);
    }

    @GetMapping("/findById")
    public CommonResult findById1(@RequestParam Integer id) {
        Role role = roleService.findById(id);
        return CommonResult.success(role);
    }

    @GetMapping("/findAll")
    public CommonResult findAll() {
        return roleService.findAllRole();
    }
}
