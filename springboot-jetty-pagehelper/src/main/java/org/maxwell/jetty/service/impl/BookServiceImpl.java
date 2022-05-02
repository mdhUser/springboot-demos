package org.maxwell.jetty.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.maxwell.jetty.entity.TblBook;
import org.maxwell.jetty.entity.vo.PageDTO;
import org.maxwell.jetty.mapper.BookMapper;
import org.maxwell.jetty.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 16:14
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public TblBook findOne(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public PageDTO<TblBook> findPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TblBook> all = bookMapper.findAll();
        PageInfo<TblBook> pageInfo = new PageInfo<>(all);
        int pages = pageInfo.getPages();
        int total = (int)pageInfo.getTotal();
        return new PageDTO<>(page,pageSize,total,pages,all);
    }
}
