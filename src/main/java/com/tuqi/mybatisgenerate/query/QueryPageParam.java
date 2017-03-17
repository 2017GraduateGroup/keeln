package com.tuqi.mybatisgenerate.query;

import lombok.Data;

/**
 * Created by zheng on 16/5/10.
 */
@Data
public class QueryPageParam {
    private Integer pageSize = 20;   //单页显示条数，默认20
    private Integer curPage = 1;    //当前页，默认为第一页
    private Integer start;          //开始页

    /**
     * 当前页从那条记录开始
     *
     * @return 记录开始的index
     */
    public Integer getStart() {
        if (start == null || start < 0) {
            if (pageSize == null || curPage == null || curPage <= 0) {
                return 0;
            }
            return pageSize * (curPage - 1);
        } else {
            return start;
        }
    }


}
