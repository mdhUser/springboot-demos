package org.maxwell.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.maxwell.mybatisplus.entity.UserPO;
import org.maxwell.mybatisplus.entity.bo.UserBO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 0:41
 */
public interface UserMapper extends BaseMapper<UserPO> {

    List<UserPO> findList(UserBO userQueryBean);

}
