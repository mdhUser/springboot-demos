package org.maxwell.webdemo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具
 */
@Data
public class PageDTO<T> implements Serializable {
    /**
     * 页码
     */
    private Integer currentPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总条数
     */
    private Integer totalRecords;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 数据集合
     */
    private List<T> list;


    public PageDTO(Integer currentPage, Integer pageSize, Integer totalRecords, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.list = list;
        this.totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
    }


}