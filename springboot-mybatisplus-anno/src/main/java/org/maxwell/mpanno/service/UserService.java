package org.maxwell.mpanno.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.mpanno.entity.TbUser;
import org.maxwell.mpanno.entity.bo.UserQueryBean;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 1:27
 */
public interface UserService extends IService<TbUser> {


    /**
     *  查找用户列表
     * @param userQueryBean
     * @return
     */
    List<TbUser> findUserList(UserQueryBean userQueryBean);

}
