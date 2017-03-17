package com.tuqi.manager;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.UserTabDO;
import com.tuqi.domain.query.UserTabQuery;

import java.util.List;


/**
 * Manager for UserTab.
 */
public interface UserTabManager {
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
    long insertSelective(UserTabDO record);

    /**
     * select by query condition.
     */
    List<UserTabDO> selectByQuery(UserTabQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<UserTabDO> selectByQueryWithPage(UserTabQuery query);

    /**
     * select by primary key.
     */
    UserTabDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( UserTabDO record,  UserTabQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(UserTabDO record, UserTabQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(UserTabDO record);
}