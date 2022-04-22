package org.maxwell.mybatisplus.controller;

import org.apache.catalina.User;
import org.maxwell.mybatisplus.entity.UserPO;
import org.maxwell.mybatisplus.entity.bo.UserBO;
import org.maxwell.mybatisplus.entity.response.ResponseResult;
import org.maxwell.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 1:35
 */

@RestController
@RequestMapping("/mp/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  用户列表
     * @return
     */
    @GetMapping("/userList")
    public ResponseResult<List<UserPO>> userList(UserBO userBO){
        return ResponseResult.success(userService.findUserList(userBO));
    }

    @PostMapping("/add")
    public ResponseResult<User> add(){
        return null;
    }




}
