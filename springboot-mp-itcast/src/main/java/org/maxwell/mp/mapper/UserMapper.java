package org.maxwell.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.maxwell.mp.entity.User;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/26 10:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
