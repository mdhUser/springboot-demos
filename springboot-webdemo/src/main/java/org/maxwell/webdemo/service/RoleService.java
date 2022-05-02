package org.maxwell.webdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.webdemo.model.po.TRole;
import org.maxwell.webdemo.model.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:21
 */
public interface RoleService extends IService<TRole> {

    /***
     *  查找角色列表
     * @return
     */
    List<TRole> findRoleList();

}
