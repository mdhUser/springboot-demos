package org.maxwell.webdemo.controller;

import org.maxwell.webdemo.model.bo.AddUser;
import org.maxwell.webdemo.model.bo.UpdateUser;
import org.maxwell.webdemo.model.dto.PageDTO;
import org.maxwell.webdemo.model.dto.ResponseResult;
import org.maxwell.webdemo.model.vo.UserVO;
import org.maxwell.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.maxwell.webdemo.constant.ResponseStatus.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/17 23:14
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList/{pageSize}/{currentPage}/{name}")
    public ResponseResult<PageDTO<UserVO>> userList(@PathVariable int pageSize, @PathVariable int currentPage, @PathVariable String name) {
        return ResponseResult.success(userService.findUserList(pageSize, currentPage, name));
    }

    @PostMapping("/addUser")
    public ResponseResult<Integer> addUser(@RequestBody AddUser user) {
        return userService.addUser(user) > 0 ? ResponseResult.success() : ResponseResult.fail(SAVE_ERROR.getDescription());
    }

    @PostMapping("/updateUser")
    public ResponseResult<Integer> updateUser(@RequestBody UpdateUser user) {
        return userService.updateUser(user) > 0 ? ResponseResult.success() : ResponseResult.fail(UPDATE_ERROR.getDescription());
    }

    @GetMapping("/deleteUser")
    public ResponseResult<Integer> deleteUser(int uid) {
        return userService.deleteUser(uid) > 0 ? ResponseResult.success() : ResponseResult.fail(DELETE_ERROR.getDescription());
    }


}
