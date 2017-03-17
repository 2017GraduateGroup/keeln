package com.tuqi.manager.impl;

import com.tuqi.domain.model.UserTabDO;
import com.tuqi.domain.query.UserTabQuery;
import com.tuqi.manager.UserTabManager;
import com.tuqi.mapper.ext.UserTabExtMapper;
import com.tuqi.mybatisgenerate.query.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for UserTab.
 */

@Component
public class UserTabManagerImpl implements UserTabManager{
    private static final Logger log = LoggerFactory.getLogger(UserTabManagerImpl.class);

    @Autowired
    protected UserTabExtMapper userTabExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(UserTabQuery query){
        return userTabExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(UserTabQuery query){
        return userTabExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(UserTabDO record){
        return userTabExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(UserTabDO record){
        return userTabExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<UserTabDO> selectByQuery(UserTabQuery query){
        return userTabExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<UserTabDO> selectByQueryWithPage(UserTabQuery query) {
        PageResult<UserTabDO> result = new PageResult<UserTabDO>();
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
    public UserTabDO selectByPrimaryKey(Long id){
        return userTabExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( UserTabDO record,  UserTabQuery query){
        return userTabExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( UserTabDO record,  UserTabQuery query){

        return userTabExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(UserTabDO record){
        return userTabExtMapper.updateByPrimaryKeySelective(record);
    }
}