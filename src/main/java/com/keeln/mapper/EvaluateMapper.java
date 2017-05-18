package com.keeln.mapper;

import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.query.EvaluateQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Evaluate.
 */
public interface EvaluateMapper {
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
    int insertSelective(EvaluateDO record);

    /**
     * select by query condition.
     */
    List<EvaluateDO> selectByQuery(EvaluateQuery query);

    /**
     * select by primary key.
     */
    EvaluateDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") EvaluateDO record, @Param("query") EvaluateQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") EvaluateDO record, @Param("query") EvaluateQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(EvaluateDO record);
}