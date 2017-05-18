package com.keeln.manager.impl;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;
import com.keeln.mapper.ext.ScenicRegionExtMapper;
import com.keeln.manager.ScenicRegionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ScenicRegion.
 */

@Component
public class ScenicRegionManagerImpl implements ScenicRegionManager{
    private static final Logger log = LoggerFactory.getLogger(ScenicRegionManagerImpl.class);

    
    @Autowired
    protected ScenicRegionExtMapper scenicRegionExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ScenicRegionQuery query){
        return scenicRegionExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ScenicRegionQuery query){
        return scenicRegionExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ScenicRegionDO record){
        return scenicRegionExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ScenicRegionDO record){
        return scenicRegionExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ScenicRegionDO> selectByQuery(ScenicRegionQuery query){
        return scenicRegionExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ScenicRegionDO> selectByQueryWithPage(ScenicRegionQuery query) {
        PageResult<ScenicRegionDO> result = new PageResult<ScenicRegionDO>();
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
    public ScenicRegionDO selectByPrimaryKey(Long id){
        return scenicRegionExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ScenicRegionDO record,  ScenicRegionQuery query){
        return scenicRegionExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ScenicRegionDO record,  ScenicRegionQuery query){

        return scenicRegionExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ScenicRegionDO record){
        return scenicRegionExtMapper.updateByPrimaryKeySelective(record);
    }
}