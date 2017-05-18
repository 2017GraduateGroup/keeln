package com.keeln.mapper;

import com.keeln.domain.model.UserDO;
import com.keeln.domain.query.UserQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for User.
 */
public interface UserMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(UserQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(UserQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(UserDO record);

    /**
     * insert selective.
     */
    int insertSelective(UserDO record);

    /**
     * select by query condition.
     */
    List<UserDO> selectByQuery(UserQuery query);

    /**
     * select by primary key.
     */
    UserDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") UserDO record, @Param("query") UserQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") UserDO record, @Param("query") UserQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(UserDO record);
}