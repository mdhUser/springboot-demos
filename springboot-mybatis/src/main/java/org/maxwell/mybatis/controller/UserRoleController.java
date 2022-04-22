package org.maxwell.mybatis.controller;

import org.maxwell.mybatis.entity.response.ResponseResult;
import org.maxwell.mybatis.serivce.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 14:50
 */

@RequestMapping("/test/mybatis/user&role")
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/add_user_role")
    public ResponseResult<Integer> addUserRole(@RequestParam("uid") int uid, @RequestParam("rids") List<Integer> rids) {
        return userRoleService.addUserRole(uid, rids) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "" +
                "新增权限失败！");
    }

    @GetMapping("/delete_user_role")
    public ResponseResult<Integer> deleteUserRoleByUid(int uid) {
        return userRoleService.deleteUserRoleByUid(uid) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "删除权限失败！");
    }

    @GetMapping("/find_rids")
    public ResponseResult<List<Integer>> findRidsByUid(int uid) {
        return ResponseResult.success(userRoleService.findRidsByUid(uid));
    }


}