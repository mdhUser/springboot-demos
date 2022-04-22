package org.maxwell.mybatisplus.service;

import org.maxwell.mybatisplus.entity.UserPO;
import org.maxwell.mybatisplus.entity.bo.UserBO;
import org.maxwell.mybatisplus.entity.vo.UserVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 1:27
 */
public interface UserService  {


    /**
     *  查找用户列表
     * @param userQueryBean
     * @return
     */
    List<UserPO> findUserList(UserBO userQueryBean);

}
