package org.maxwell.mpanno.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.maxwell.mpanno.entity.TbUser;
import org.maxwell.mpanno.entity.bo.UserQueryBean;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 0:41
 */
public interface UserMapper extends BaseMapper<TbUser> {

    List<TbUser> findList(UserQueryBean userQueryBean);

}
