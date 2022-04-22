package org.maxwell.mpanno.controller;

import org.maxwell.mpanno.entity.TbUser;
import org.maxwell.mpanno.entity.bo.UserQueryBean;
import org.maxwell.mpanno.entity.response.ResponseResult;
import org.maxwell.mpanno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
     * 用户列表
     *
     * @return
     */
    @GetMapping("/userList")
    public ResponseResult<List<TbUser>> userList(UserQueryBean queryBean) {
        return ResponseResult.success(userService.findUserList(queryBean));
    }

    /**
     * @param user user param
     * @return user
     */
    @PostMapping("/add")
    public ResponseResult<TbUser> add(TbUser user) {
        if (null == user.getId())
            user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
        return ResponseResult.success(userService.getById(user.getId()));
    }


    /**
     * 查找用户
     * @param userId
     * @return
     */
    @GetMapping("/edit/{userId}")
    public ResponseResult<TbUser> edit(@PathVariable("userId") int userId){
        return ResponseResult.success(userService.getById(userId));
    }




}
