package com.keeln.controller;

import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;
import com.keeln.manager.ScenicRegionManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by keeln on 17/3/11.
 */
@RestController
@RequestMapping("scenic")
public class ScenicRegionController {

    @Autowired
    ScenicRegionManager scenicRegionManager;

    //添加景区信息
    @RequestMapping("addScenicRegionInfo")
    public void addScenicRegionInfo(String title, String grade, String priceMin, String commCnt,
                                    String cityId, String address, String sid, String url, String imgUlr){
        ScenicRegionDO scenicRegionDO = new ScenicRegionDO();
        if(StringUtils.isNoneBlank(title)){
            scenicRegionDO.setTitle(title);
        }
        if(StringUtils.isNoneBlank(grade)){
            scenicRegionDO.setGrade(grade);
        }
        if(StringUtils.isNoneBlank(priceMin)){
            scenicRegionDO.setPriceMin(priceMin);
        }
        if(StringUtils.isNoneBlank(commCnt)){
            scenicRegionDO.setCommCnt(commCnt);
        }
        if(StringUtils.isNoneBlank(cityId)){
            scenicRegionDO.setCityid(cityId);
        }
        if(StringUtils.isNoneBlank(address)){
            scenicRegionDO.setAddress(address);
        }
        if(StringUtils.isNoneBlank(sid)){
            scenicRegionDO.setSid(sid);
        }
        if(StringUtils.isNoneBlank(url)){
            scenicRegionDO.setUrl(url);
        }
        if(StringUtils.isNoneBlank(imgUlr)){
            scenicRegionDO.setImgurl(imgUlr);
        }
        scenicRegionManager.insertSelective(scenicRegionDO);
    }

    //修改景区信息
    @RequestMapping("updateScenicRegionInfo")
    public void updateScenicRegionInfo(@RequestParam String scenicRegionId, String title, String grade, String priceMin, String commCnt,
                                    String cityId, String address, String sid, String url, String imgUlr){
        if(StringUtils.isNotBlank(scenicRegionId)){
            ScenicRegionDO scenicRegionDO = scenicRegionManager.selectByPrimaryKey(Long.valueOf(scenicRegionId));
            if(StringUtils.isNoneBlank(title)){
                scenicRegionDO.setTitle(title);
            }
            if(StringUtils.isNoneBlank(grade)){
                scenicRegionDO.setGrade(grade);
            }
            if(StringUtils.isNoneBlank(priceMin)){
                scenicRegionDO.setPriceMin(priceMin);
            }
            if(StringUtils.isNoneBlank(commCnt)){
                scenicRegionDO.setCommCnt(commCnt);
            }
            if(StringUtils.isNoneBlank(cityId)){
                scenicRegionDO.setCityid(cityId);
            }
            if(StringUtils.isNoneBlank(address)){
                scenicRegionDO.setAddress(address);
            }
            if(StringUtils.isNoneBlank(sid)){
                scenicRegionDO.setSid(sid);
            }
            if(StringUtils.isNoneBlank(url)){
                scenicRegionDO.setUrl(url);
            }
            if(StringUtils.isNoneBlank(imgUlr)){
                scenicRegionDO.setImgurl(imgUlr);
            }
            scenicRegionManager.insertSelective(scenicRegionDO);
        }
    }

    //删除景区信息
    @RequestMapping("deleteScenicRegionInfo")
    public void deleteScenicRegionInfo(@RequestParam String scenicRegionId){
        if(StringUtils.isNotBlank(scenicRegionId)){
            ScenicRegionDO scenicRegionDO = scenicRegionManager.selectByPrimaryKey(Long.valueOf(scenicRegionId));
            if(null != scenicRegionDO){
                scenicRegionManager.deleteByPrimaryKey(scenicRegionDO);
            }
        }
    }
    //获取所有景区信息
    @RequestMapping(value = "getAllScenicRegion", method = RequestMethod.POST)
    public List getAllScenicRegion(){
        ScenicRegionQuery scenicRegionQuery = new ScenicRegionQuery();
        scenicRegionQuery.createCriteria().andIdIsNotNull();
        List<ScenicRegionDO> scenicRegionDOList = scenicRegionManager.selectByQuery(scenicRegionQuery);
        return scenicRegionDOList;
    }
}
