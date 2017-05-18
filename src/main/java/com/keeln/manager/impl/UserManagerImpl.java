package com.keeln.manager.impl;

import com.keeln.mybatisgenerate.query.PageResult;
import com.keeln.domain.model.UserDO;
import com.keeln.domain.query.UserQuery;
import com.keeln.mapper.ext.UserExtMapper;
import com.keeln.manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for User.
 */

@Component
public class UserManagerImpl implements UserManager{
    private static final Logger log = LoggerFactory.getLogger(UserManagerImpl.class);

    
    @Autowired
    protected UserExtMapper userExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(UserQuery query){
        return userExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(UserQuery query){
        return userExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(UserDO record){
        return userExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(UserDO record){
        return userExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<UserDO> selectByQuery(UserQuery query){
        return userExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<UserDO> selectByQueryWithPage(UserQuery query) {
        PageResult<UserDO> result = new PageResult<UserDO>();
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
    public UserDO selectByPrimaryKey(Long id){
        return userExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( UserDO record,  UserQuery query){
        return userExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( UserDO record,  UserQuery query){

        return userExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(UserDO record){
        return userExtMapper.updateByPrimaryKeySelective(record);
    }
}