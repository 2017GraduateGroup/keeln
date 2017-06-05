package com.keeln.controller;

import com.keeln.domain.model.BizResult;
import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.query.EvaluateQuery;
import com.keeln.manager.EvaluateManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Xianrui Ke on 2017/5/18.
 */
@RestController
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    EvaluateManager evaluateManager;

    @RequestMapping("addEvaluate")
    public BizResult addEvaluate(@RequestParam String userId, @RequestParam String scenicRegionId, @RequestParam String content){
        BizResult bizResult = new BizResult();
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
        Long result = evaluateManager.insertSelective(evaluateDO);
        if(result > 0){
            bizResult.setCode("1");
            bizResult.setMessage("success");
            return bizResult;
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    @RequestMapping("deleteEvaluate")
    public BizResult deleteEvaluate(@RequestParam String userId, @RequestParam String evaluateId){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(evaluateId)){
            EvaluateDO evaluateDO = evaluateManager.selectByPrimaryKey(Long.valueOf(evaluateId));
            //判断当前评论存在并且属于该用户，才可以删除
            if(null != evaluateDO){
                if(evaluateDO.getUserId().equals(Long.valueOf(userId))){
                   Integer result =  evaluateManager.deleteByPrimaryKey(evaluateDO);
                   if(result > 0){
                       bizResult.setCode("1");
                       bizResult.setMessage("success");
                       return bizResult;
                   }
                }
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    @RequestMapping("updateEvaluate")
    public BizResult updateEvaluate(@RequestParam String userId, @RequestParam String evaluateId, @RequestParam String content){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(evaluateId)){
            EvaluateDO evaluateDO = evaluateManager.selectByPrimaryKey(Long.valueOf(evaluateId));
            if(null != evaluateDO){
                if(evaluateDO.getUserId().equals(Long.valueOf(userId)) && StringUtils.isNotBlank(content)){
                    evaluateDO.setContent(content);
                    Integer result = evaluateManager.updateByPrimaryKeySelective(evaluateDO);
                    if(result > 0){
                        bizResult.setCode("1");
                        bizResult.setMessage("success");
                        return bizResult;
                    }
                }
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
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
