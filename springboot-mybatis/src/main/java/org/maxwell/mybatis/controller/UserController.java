package org.maxwell.mybatis.controller;

import org.maxwell.mybatis.entity.model.UserMapRole;
import org.maxwell.mybatis.entity.model.UserPermissionVO;
import org.maxwell.mybatis.entity.model.UserRoleVO;
import org.maxwell.mybatis.entity.response.ResponseResult;
import org.maxwell.mybatis.serivce.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 13:57
 */
@RequestMapping("/test/mybatis/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find_user&roles_page")
    public ResponseResult<List<UserRoleVO>> findUserRolesPage(int from, int total) {
        List<UserRoleVO> userRolesLimit = userService.findUserRolesLimit(from, total);
        return ResponseResult.success(userRolesLimit);
    }

    @PostMapping("/add_user")
    public ResponseResult<Integer> addUser(@RequestBody UserMapRole user) {
        return userService.addUser(user) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "新增失败！");
    }

    @PostMapping("/update_user")
    public ResponseResult<Integer> updateUser(@RequestBody UserMapRole tUser) {
        return userService.updateUser(tUser) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "修改失败！");
    }

    @GetMapping("/delete_user")
    public ResponseResult<Integer> deleteUserByUid(int uid) {
        return userService.deleteUserByUid(uid) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "删除失败！");
    }

    @GetMapping("/find_user_permission_page")
    public ResponseResult<List<UserPermissionVO>> findUserPermissionPage(int from, int total) {
        List<UserPermissionVO> userPermissionLimit = userService.findUserPermissionLimit(from, total);
        return ResponseResult.success(userPermissionLimit);
    }

    @GetMapping("/find_user_permission")
    public ResponseResult<UserPermissionVO> findUserPermissionByUid(int uid) {
        UserPermissionVO userPermissionByUid = userService.findUserPermissionByUid(uid);
        return ResponseResult.success(userPermissionByUid);
    }

    @PostMapping("/update_user&roles")
    public ResponseResult<Integer> updateUserAndRoles(@RequestBody UserMapRole userMapRole) {
        return userService.updateUserAndRoles(userMapRole) > 0 ? ResponseResult.success() : ResponseResult.fail(-1, "修改失败！");
    }

}