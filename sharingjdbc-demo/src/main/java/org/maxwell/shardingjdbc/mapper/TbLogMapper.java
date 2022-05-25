package org.maxwell.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.maxwell.shardingjdbc.entity.TbLog;

/**
* @author Maxwell
* @description 针对表【tb_log】的数据库操作Mapper
* @createDate 2022-05-20 23:42:42
* @Entity org.maxwell.sharingjdbc.entity.TbLog
*/
@Mapper
public interface TbLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbLog record);

    int insertSelective(TbLog record);

    TbLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbLog record);

    int updateByPrimaryKey(TbLog record);

}
