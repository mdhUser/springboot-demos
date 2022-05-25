package org.maxwell.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.maxwell.shardingjdbc.entity.TUser;

/**
* @author Maxwell
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-05-20 23:03:31
* @Entity org.maxwell.sharingjdbc.entity.TUser
*/
@Mapper
public interface TUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

}
