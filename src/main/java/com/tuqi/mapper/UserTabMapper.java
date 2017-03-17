package com.tuqi.mapper;

import com.tuqi.domain.model.UserTabDO;
import com.tuqi.domain.query.UserTabQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for UserTab.
 */
public interface UserTabMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(UserTabQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(UserTabQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(UserTabDO record);

    /**
     * insert selective.
     */
    int insertSelective(UserTabDO record);

    /**
     * select by query condition.
     */
    List<UserTabDO> selectByQuery(UserTabQuery query);

    /**
     * select by primary key.
     */
    UserTabDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") UserTabDO record, @Param("query") UserTabQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") UserTabDO record, @Param("query") UserTabQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(UserTabDO record);
}