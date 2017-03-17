package com.tuqi.mappertest;

import com.tuqi.domain.model.UserTabDO;
import com.tuqi.domain.query.UserTabQuery;
import com.tuqi.manager.UserTabManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by tuqi on 17/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootApplication
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserTabManager userTabManager;

    @Test
    public void findUsers(){
        UserTabQuery userTabQuery = new UserTabQuery();
        userTabQuery.createCriteria().andGmtCreateIsNotNull();
        List<UserTabDO> userTabQueryList = userTabManager.selectByQuery(userTabQuery);
    }
}
