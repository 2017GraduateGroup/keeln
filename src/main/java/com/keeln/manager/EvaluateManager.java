package com.keeln.manager;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.query.EvaluateQuery;

import java.util.List;


/**
 * Manager for Evaluate.
 */
public interface EvaluateManager {
    /**
     * query count by query condition.
     */
    int countByQuery(EvaluateQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(EvaluateQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(EvaluateDO record);

    /**
     * insert selective.
     */
    long insertSelective(EvaluateDO record);

    /**
     * select by query condition.
     */
    List<EvaluateDO> selectByQuery(EvaluateQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<EvaluateDO> selectByQueryWithPage(EvaluateQuery query);

    /**
     * select by primary key.
     */
    EvaluateDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( EvaluateDO record,  EvaluateQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(EvaluateDO record, EvaluateQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(EvaluateDO record);
}