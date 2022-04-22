package org.maxwell.mpanno.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.mpanno.entity.TbRole;
import org.maxwell.mpanno.entity.bo.RoleQueryBean;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 23:52
 */
public interface RoleService extends IService<TbRole> {


    List<TbRole> findList(RoleQueryBean queryBean);

}
