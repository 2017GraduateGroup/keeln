package com.keeln.manager;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.ApiDataDO;
import com.keeln.domain.query.ApiDataQuery;

import java.util.List;


/**
 * Manager for ApiData.
 */
public interface ApiDataManager {
    /**
     * query count by query condition.
     */
    int countByQuery(ApiDataQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ApiDataQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ApiDataDO record);

    /**
     * insert selective.
     */
    long insertSelective(ApiDataDO record);

    /**
     * select by query condition.
     */
    List<ApiDataDO> selectByQuery(ApiDataQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ApiDataDO> selectByQueryWithPage(ApiDataQuery query);

    /**
     * select by primary key.
     */
    ApiDataDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ApiDataDO record,  ApiDataQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ApiDataDO record, ApiDataQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ApiDataDO record);
}