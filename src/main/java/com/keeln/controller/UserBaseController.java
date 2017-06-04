package com.keeln.controller;

import com.keeln.domain.model.BizResult;
import com.keeln.domain.model.UserDO;
import com.keeln.domain.query.UserQuery;
import com.keeln.manager.UserManager;
import com.keeln.util.MyMD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xianrui Ke on 2017/5/18.
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserBaseController {
    @Autowired
    UserManager userManager;

    //用户注册
    @RequestMapping("userRegister")
    public BizResult userRegister(@RequestParam String rUsename, @RequestParam String rPasswd, @RequestParam(required = false) String rNickname,
                                  @RequestParam(required = false) String gender){
        UserDO userDO = new UserDO();
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(rUsename)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNameEqualTo(rUsename);
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(userDOList.size() > 0){
                log.info("user is exist, please change");
                bizResult.setCode("0");
                bizResult.setMessage("fail");
                return bizResult;
            }else {
                if(StringUtils.isNotBlank(rUsename)){
                    userDO.setUserName(rUsename);
                }
                if(StringUtils.isNotBlank(rPasswd)){
                    userDO.setPassword(MyMD5Util.code(rPasswd));
                }
                if(StringUtils.isNotBlank(rNickname)){
                    userDO.setNickName(rNickname);
                }
                if(StringUtils.isNotBlank(gender)){
                    userDO.setUserGender(gender);
                }
                userDO.setUserIdentifyId(0);
                Long result = userManager.insertSelective(userDO);
                if(result > 0){
                    log.info("insert new user success", userDO.getUserName());
                    bizResult.setCode("1");
                    bizResult.setMessage("success");
                    return bizResult;
                }else{
                    log.info("insert new user fail");
                    bizResult.setCode("0");
                    bizResult.setMessage("fail");
                    return bizResult;
                }
            }
        }
        return bizResult;
    }

    //用户登录
    @RequestMapping("userLogin")
    public BizResult userLogin(@RequestParam String usernameInput, @RequestParam String passwdInput, HttpServletRequest request){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(usernameInput)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNameEqualTo(usernameInput).andPasswordEqualTo(MyMD5Util.code(passwdInput));
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(userDOList.size() > 0){
                request.getSession().setAttribute("currentUserId", userDOList.get(0).getUserId());
                bizResult.setCode("1");
                bizResult.setData(userDOList.get(0).getUserId().toString());
                bizResult.setMessage("login success");
                return bizResult;
            }else{
                bizResult.setCode("0");
                bizResult.setMessage("login fail");
                return bizResult;
            }
        }
        return bizResult;
    }

    //获取所有的用户信息
    @RequestMapping("getAllUserInfo")
    public List getAllUserInfo(){
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUserIdIsNotNull();
        List<UserDO> userDOList = userManager.selectByQuery(userQuery);
        return userDOList;
    }

    //修改用户信息
    @RequestMapping("updateUserInfo")
    public BizResult updateUserInfo(@RequestParam String userId,String userName, String nickName, String gender, String password){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(userId)){
            UserDO userDO = userManager.selectByPrimaryKey(Long.valueOf(userId));
            if(userDO != null){
                if(StringUtils.isNotBlank(userName)){
                    userDO.setUserName(userName);
                }
                if(StringUtils.isNotBlank(nickName)){
                    userDO.setNickName(nickName);
                }
                if(StringUtils.isNotBlank(gender)){
                   userDO.setUserGender(gender);
                }
                if(StringUtils.isNotBlank(password)){
                    userDO.setPassword(password);
                }
                Integer result = userManager.updateByPrimaryKeySelective(userDO);
                if(result > 0){
                    bizResult.setCode("1");
                    bizResult.setMessage("success");
                    return bizResult;
                }
                log.info("update user info success", userId);
            }
        }else {
            log.info("user id is null", userId);
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }
}
