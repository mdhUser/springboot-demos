package org.maxwell.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.maxwell.shardingjdbc.entity.TDict;

/**
* @author Maxwell
* @description 针对表【t_dict】的数据库操作Mapper
* @createDate 2022-05-20 18:20:09
* @Entity org.maxwell.sharingjdbc.entity.TDict
*/
@Mapper
public interface TDictMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TDict record);

    int insertSelective(TDict record);

    TDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDict record);

    int updateByPrimaryKey(TDict record);

}
