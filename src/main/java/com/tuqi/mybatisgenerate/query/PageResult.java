package com.tuqi.mybatisgenerate.query;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> pageData = Lists.newArrayList();

    private int pageNo = BaseQuery.DEFAULT_PAGE;

    private int totalCount; // 总的数目

    private int pageSize = BaseQuery.DEFAULT_PAGE_SIZE; //每一页数目

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        if (pageNo < 1) {
            pageNo = BaseQuery.DEFAULT_PAGE;
        }
        return totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageResult() {

    }

    public PageResult(int size, int no, int count) {
        pageSize = size;
        pageNo = no;
        totalCount = count;
        pageData = new LinkedList<T>();
    }

    public PageResult(int size, int no, int count, List<T> tList) {
        pageSize = size;
        pageNo = no;
        totalCount = count;
        pageData = tList;
    }
}
