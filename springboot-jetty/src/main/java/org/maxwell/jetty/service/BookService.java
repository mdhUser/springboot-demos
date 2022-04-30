package org.maxwell.jetty.service;

import org.maxwell.jetty.entity.TblBook;
import org.maxwell.jetty.entity.vo.PageDTO;
import org.maxwell.jetty.entity.vo.ResponseResult;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 16:14
 */
public interface BookService {

    /**
     *  查找用户
     * @param id
     * @return
     */
    TblBook findOne(int id);

    PageDTO<TblBook> findPage(int page, int pageSize);
}
