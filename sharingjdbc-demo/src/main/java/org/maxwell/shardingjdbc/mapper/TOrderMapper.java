package org.maxwell.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.maxwell.shardingjdbc.entity.TOrder;

import java.util.List;

/**
* @author Maxwell
* @description 针对表【t_order_1】的数据库操作Mapper
* @createDate 2022-05-20 15:21:12
* @Entity org.maxwell.sharingjdbc.entity.TOrder1
*/
@Mapper
public interface TOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

    List<TOrder> findByUserId(long userId);
}
