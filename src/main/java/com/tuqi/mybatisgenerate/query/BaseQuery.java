package com.tuqi.mybatisgenerate.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by houenxun on 16/1/19.
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public final static int DEFAULT_PAGE_SIZE = 20;  //  默认页大小
    public final static int MAX_PAGE_SIZE = 100;      // 最大页大小
    public final static int DEFAULT_PAGE = 1;  // 默认分页
    /**
     * order by clause.
     */
    protected String orderByClause;

    /**
     * group by clause.
     */
    protected String groupByClause;

    /**
     * distinct
     */
    protected boolean distinct;

    /**
     * criteria list
     */
    protected List<BaseCriteria> oredCriteria;

    /**
     * page
     */
    protected Integer pageOffset;


    protected Integer pageNo;

    /**
     * page size
     */
    protected Integer pageSize;

    public BaseQuery() {
        oredCriteria = new ArrayList<BaseCriteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public String getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<BaseCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(BaseCriteria criteria) {
        oredCriteria.add(criteria);
    }


    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        groupByClause = null;
        distinct = false;
    }

    public void clearPage() {
        this.pageSize = null;
        this.pageNo = null;
        this.pageOffset = null;
    }

    protected void calPageOffset() {
        if (null == pageSize || null == pageNo) {
            pageOffset = null;
        } else {
            pageOffset = (pageNo - 1) * pageSize;
        }
    }

    public boolean isValid() {
        for (int i = 0; i < oredCriteria.size(); i++) {
            if (oredCriteria.get(i).isValid()) {
                return true;
            }
        }
        return false;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            this.clearPage();
        } else if (pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        this.calPageOffset();
    }

    public Integer getPageSize() {
        return pageSize;
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo == null || pageNo < DEFAULT_PAGE) {
            this.clearPage();
        } else {
            this.pageNo = pageNo;
        }
        this.calPageOffset();
    }

}
