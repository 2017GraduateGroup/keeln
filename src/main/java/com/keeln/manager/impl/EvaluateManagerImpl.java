package com.keeln.manager.impl;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.query.EvaluateQuery;
import com.keeln.mapper.ext.EvaluateExtMapper;
import com.keeln.manager.EvaluateManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Evaluate.
 */

@Component
public class EvaluateManagerImpl implements EvaluateManager{
    private static final Logger log = LoggerFactory.getLogger(EvaluateManagerImpl.class);

    
    @Autowired
    protected EvaluateExtMapper evaluateExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(EvaluateQuery query){
        return evaluateExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(EvaluateQuery query){
        return evaluateExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(EvaluateDO record){
        return evaluateExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(EvaluateDO record){
        return evaluateExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<EvaluateDO> selectByQuery(EvaluateQuery query){
        return evaluateExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<EvaluateDO> selectByQueryWithPage(EvaluateQuery query) {
        PageResult<EvaluateDO> result = new PageResult<EvaluateDO>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setPageData(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    @Override
    public EvaluateDO selectByPrimaryKey(Long id){
        return evaluateExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( EvaluateDO record,  EvaluateQuery query){
        return evaluateExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( EvaluateDO record,  EvaluateQuery query){

        return evaluateExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(EvaluateDO record){
        return evaluateExtMapper.updateByPrimaryKeySelective(record);
    }
}