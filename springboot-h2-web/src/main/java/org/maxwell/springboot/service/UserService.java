package org.maxwell.springboot.service;

import org.maxwell.springboot.entity.User;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/26 13:01
 */
public interface UserService {

    void addUser(User user);

    List<User> list();

}
