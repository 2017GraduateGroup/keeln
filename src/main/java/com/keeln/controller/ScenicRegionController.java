package com.keeln.controller;

import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;
import com.keeln.manager.ScenicRegionManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addScenicRegionInfo(String title, String grade, String priceMin, String detail,
                                    String area, String address, String hotFlag, String url, String imgUlr){
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
        if(StringUtils.isNoneBlank(area)){
            scenicRegionDO.setArea(Integer.valueOf(area));
        }
        if(StringUtils.isNoneBlank(address)){
            scenicRegionDO.setAddress(address);
        }
        if(StringUtils.isNoneBlank(hotFlag)){
            scenicRegionDO.setHotFlag(Integer.valueOf(hotFlag));
        }
        if(StringUtils.isNoneBlank(url)){
            scenicRegionDO.setUrl(url);
        }
        if(StringUtils.isNoneBlank(imgUlr)){
            scenicRegionDO.setImgurl(imgUlr);
        }
        if(StringUtils.isNoneBlank((detail))) {
            scenicRegionDO.setDetail(detail);
        }
        scenicRegionManager.insertSelective(scenicRegionDO);
    }

    //修改景区信息
    @RequestMapping("updateScenicRegionInfo")
    public void updateScenicRegionInfo(@RequestParam String scenicRegionId, String title, String grade, String priceMin,
                                    String area, String address, String hotFlag, String url, String imgUlr, String detail){
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
            if(StringUtils.isNoneBlank(area)){
                scenicRegionDO.setArea(Integer.valueOf(area));
            }
            if(StringUtils.isNoneBlank(address)){
                scenicRegionDO.setAddress(address);
            }
            if(StringUtils.isNoneBlank(hotFlag)){
                scenicRegionDO.setHotFlag(Integer.valueOf(hotFlag));
            }
            if(StringUtils.isNoneBlank(url)){
                scenicRegionDO.setUrl(url);
            }
            if(StringUtils.isNoneBlank(imgUlr)){
                scenicRegionDO.setImgurl(imgUlr);
            }
            if(StringUtils.isNotBlank(detail)) {
                scenicRegionDO.setDetail(detail);
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
    @ResponseBody
<<<<<<< HEAD
    @RequestMapping(value = "getAllScenicRegion")
=======
    @RequestMapping(value = "getAllScenicRegion", method = RequestMethod.POST)
>>>>>>> c81475e88f59eaa4dc8b13281e565592f0a06bd0
    public List getAllScenicRegion(){
        ScenicRegionQuery scenicRegionQuery = new ScenicRegionQuery();
        scenicRegionQuery.createCriteria().andIdIsNotNull();
        List<ScenicRegionDO> scenicRegionDOList = scenicRegionManager.selectByQuery(scenicRegionQuery);
        return scenicRegionDOList;
//        return "/demo";
    }
}
