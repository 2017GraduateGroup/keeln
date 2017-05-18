package com.keeln.manager;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;

import java.util.List;


/**
 * Manager for ScenicRegion.
 */
public interface ScenicRegionManager {
    /**
     * query count by query condition.
     */
    int countByQuery(ScenicRegionQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ScenicRegionQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ScenicRegionDO record);

    /**
     * insert selective.
     */
    long insertSelective(ScenicRegionDO record);

    /**
     * select by query condition.
     */
    List<ScenicRegionDO> selectByQuery(ScenicRegionQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ScenicRegionDO> selectByQueryWithPage(ScenicRegionQuery query);

    /**
     * select by primary key.
     */
    ScenicRegionDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ScenicRegionDO record,  ScenicRegionQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ScenicRegionDO record, ScenicRegionQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ScenicRegionDO record);
}