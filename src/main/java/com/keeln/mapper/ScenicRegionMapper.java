package com.keeln.mapper;

import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for ScenicRegion.
 */
public interface ScenicRegionMapper {
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
    int insertSelective(ScenicRegionDO record);

    /**
     * select by query condition.
     */
    List<ScenicRegionDO> selectByQuery(ScenicRegionQuery query);

    /**
     * select by primary key.
     */
    ScenicRegionDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ScenicRegionDO record, @Param("query") ScenicRegionQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ScenicRegionDO record, @Param("query") ScenicRegionQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ScenicRegionDO record);
}