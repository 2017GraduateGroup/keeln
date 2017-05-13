package com.keeln.manager.impl;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.ApiDataDO;
import com.keeln.domain.query.ApiDataQuery;
import com.keeln.mapper.ext.ApiDataExtMapper;
import com.keeln.manager.ApiDataManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ApiData.
 */

@Component
public class ApiDataManagerImpl implements ApiDataManager{
    private static final Logger log = LoggerFactory.getLogger(ApiDataManagerImpl.class);

    
    @Autowired
    protected ApiDataExtMapper apiDataExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ApiDataQuery query){
        return apiDataExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ApiDataQuery query){
        return apiDataExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ApiDataDO record){
        return apiDataExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ApiDataDO record){
        return apiDataExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ApiDataDO> selectByQuery(ApiDataQuery query){
        return apiDataExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ApiDataDO> selectByQueryWithPage(ApiDataQuery query) {
        PageResult<ApiDataDO> result = new PageResult<ApiDataDO>();
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
    public ApiDataDO selectByPrimaryKey(Long id){
        return apiDataExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ApiDataDO record,  ApiDataQuery query){
        return apiDataExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ApiDataDO record,  ApiDataQuery query){

        return apiDataExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ApiDataDO record){
        return apiDataExtMapper.updateByPrimaryKeySelective(record);
    }
}