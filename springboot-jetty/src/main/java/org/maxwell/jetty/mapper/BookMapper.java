package org.maxwell.jetty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.maxwell.jetty.entity.TblBook;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 16:02
 */
@Mapper
public interface BookMapper extends BaseMapper<TblBook> {


    /**
     *  查找所有
     * @return
     */
    @Select("select * from tbl_book")
    List<TblBook> findAll();

}
