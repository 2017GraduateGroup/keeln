package com.keeln.controller;

import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.query.EvaluateQuery;
import com.keeln.manager.EvaluateManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Xianrui Ke on 2017/5/18.
 */
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    EvaluateManager evaluateManager;

    @RequestMapping("addEvaluate")
    public void addEvaluate(@RequestParam String userId, @RequestParam String scenicRegionId, @RequestParam String content){
        EvaluateDO evaluateDO = new EvaluateDO();
        if(StringUtils.isNotBlank(userId)){
            evaluateDO.setUserId(Long.valueOf(userId));
        }
        if(StringUtils.isNotBlank(scenicRegionId)){
            evaluateDO.setScenicRegionId(Long.valueOf(scenicRegionId));
        }
        if(StringUtils.isNotBlank(content)){
            evaluateDO.setContent(content);
        }
        evaluateManager.insertSelective(evaluateDO);
    }

    @RequestMapping("deleteEvaluate")
    public void deleteEvaluate(@RequestParam String userId, @RequestParam String evaluateId){
        if(StringUtils.isNotBlank(evaluateId)){
            EvaluateDO evaluateDO = evaluateManager.selectByPrimaryKey(Long.valueOf(evaluateId));
            //判断当前评论存在并且属于该用户，才可以删除
            if(null != evaluateDO){
                if(evaluateDO.getUserId().equals(Long.valueOf(userId))){
                    evaluateManager.deleteByPrimaryKey(evaluateDO);
                }
            }
        }
    }

    @RequestMapping("updateEvaluate")
    public void updateEvaluate(@RequestParam String userId, @RequestParam String evaluateId, @RequestParam String content){
        if(StringUtils.isNotBlank(evaluateId)){
            EvaluateDO evaluateDO = evaluateManager.selectByPrimaryKey(Long.valueOf(evaluateId));
            if(null != evaluateDO){
                if(evaluateDO.getUserId().equals(Long.valueOf(userId)) && StringUtils.isNotBlank(content)){
                    evaluateDO.setContent(content);
                    evaluateManager.updateByPrimaryKeySelective(evaluateDO);
                }
            }
        }
    }

    @RequestMapping("queryCurrScenicEvaluateList")
    public List queryCurrScenicEvaluateList(@RequestParam String scenicRegionId){
        if(StringUtils.isNotBlank(scenicRegionId)){
            EvaluateQuery evaluateQuery = new EvaluateQuery();
            evaluateQuery.createCriteria().andScenicRegionIdEqualTo(Long.valueOf(scenicRegionId));
            List<EvaluateDO> scenicRegionDOList = evaluateManager.selectByQuery(evaluateQuery);
            return scenicRegionDOList;
        }
        return null;
    }
}
