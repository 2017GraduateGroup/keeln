package com.keeln.controller;

import com.keeln.domain.model.ApiDataDO;
import com.keeln.domain.query.ApiDataQuery;
import com.keeln.manager.ApiDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by keeln on 17/3/11.
 */
@RestController
@RequestMapping("data")
public class ReturnJsonDataController {

    @Autowired
    ApiDataManager apiDataManager;

    @RequestMapping(value = "getAllApiData", method = RequestMethod.POST)
    public List getAllApiData(){
        ApiDataQuery apiDataQuery = new ApiDataQuery();
        apiDataQuery.createCriteria().andIdIsNotNull();
        List<ApiDataDO> apiDataDOList = apiDataManager.selectByQuery(apiDataQuery);
        return apiDataDOList;
    }
}
