package org.maxwell.webdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.webdemo.model.bo.AddUser;
import org.maxwell.webdemo.model.bo.UpdateUser;
import org.maxwell.webdemo.model.dto.PageDTO;
import org.maxwell.webdemo.model.po.TUser;
import org.maxwell.webdemo.model.vo.UserVO;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/17 23:56
 */
public interface UserService extends IService<TUser> {

    /**
     * 模糊分页查找用户列表
     *
     * @param pageSize
     * @param currentPage
     * @return
     */
    PageDTO<UserVO> findUserList(int pageSize, int currentPage, String name);


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(AddUser user);


    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(UpdateUser user);


    /***
     *  删除用户
     * @param uid
     * @return
     */
    int deleteUser(int uid);
}