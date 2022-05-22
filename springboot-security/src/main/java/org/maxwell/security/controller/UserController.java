package org.maxwell.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/22 14:51
 */
@RestController
public class UserController {

    @PreAuthorize("hasAnyAuthority('P5')")
//    @PostAuthorize() 在权限之后
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/say")
    public String say() {
        return "say security";
    }


    @GetMapping("/register")
//    @PermitAll 允许所有用户
    @PreAuthorize("isAnonymous()")
    public String register() {
        return "register security";
    }

}
