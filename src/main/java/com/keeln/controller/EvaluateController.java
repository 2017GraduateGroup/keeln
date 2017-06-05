package com.keeln.controller;

import com.keeln.domain.model.BizResult;
import com.keeln.domain.model.EvaluateDO;
import com.keeln.domain.model.EvaluateVO;
import com.keeln.domain.query.EvaluateQuery;
import com.keeln.manager.EvaluateManager;
import com.keeln.manager.UserManager;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Xianrui Ke on 2017/5/18.
 */
@RestController
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    EvaluateManager evaluateManager;
    @Autowired
    UserManager userManager;

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
    public BizResult queryCurrScenicEvaluateList(@RequestParam String scenicRegionId){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(scenicRegionId)){
            EvaluateQuery evaluateQuery = new EvaluateQuery();
            evaluateQuery.createCriteria().andScenicRegionIdEqualTo(Long.valueOf(scenicRegionId));
            List<EvaluateDO> evaluateDOS = evaluateManager.selectByQuery(evaluateQuery);
            List<EvaluateVO> evaluateVOS = new ArrayList<>();
            for(EvaluateDO evaluateDO : evaluateDOS){
                EvaluateVO evaluateVO = new EvaluateVO();
                evaluateVO.setEvaluateId(evaluateDO.getEvaluateId());
                evaluateVO.setContent(evaluateDO.getContent());
                evaluateVO.setEvaluateUserName(userManager.selectByPrimaryKey(evaluateDO.getUserId()).getUserName());
                evaluateVO.setUserId(evaluateDO.getUserId());
                evaluateVO.setScenicRegionId(evaluateDO.getScenicRegionId());
                evaluateVOS.add(evaluateVO);
            }
            bizResult.setCode("1");
            bizResult.setMessage("success");
            bizResult.setList(evaluateVOS);
            return bizResult;
        }
        bizResult.setCode("1");
        bizResult.setMessage("fail");
        return bizResult;
    }
}