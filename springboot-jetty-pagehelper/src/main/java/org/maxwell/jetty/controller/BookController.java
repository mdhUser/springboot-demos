package org.maxwell.jetty.controller;

import org.maxwell.jetty.entity.TblBook;
import org.maxwell.jetty.entity.vo.PageDTO;
import org.maxwell.jetty.entity.vo.ResponseResult;
import org.maxwell.jetty.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 15:55
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseResult<TblBook> findOne(@PathVariable Integer id) {
        return ResponseResult.success(bookService.findOne(id));
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody TblBook book) {
        return ResponseResult.success();
    }

    @GetMapping("/all")
    public ResponseResult<PageDTO<TblBook>> findPage(int page, int pageSize) {
        return ResponseResult.success(bookService.findPage(page, pageSize));
    }


}
