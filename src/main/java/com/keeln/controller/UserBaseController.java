package com.keeln.controller;

import com.keeln.domain.model.UserDO;
import com.keeln.domain.query.UserQuery;
import com.keeln.manager.UserManager;
import com.keeln.util.MyMD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xianrui Ke on 2017/5/18.
 */
@Controller
@RequestMapping("user")
public class UserBaseController {
    @Autowired
    UserManager userManager;

    //用户注册
    @RequestMapping("userRegister")
    public String userRegister(@RequestParam String rUsename, @RequestParam String rPasswd, @RequestParam(required = false) String rNickname,
                               @RequestParam(required = false) String gender){
        UserDO userDO = new UserDO();
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

        userManager.insertSelective(userDO);
        return "/loginAndRegister";
    }
    //用户登录
    @RequestMapping("userLogin")
    public void userLogin(@RequestParam String usernameInput, @RequestParam String passwdInput, HttpServletRequest request, Model model){
        if(StringUtils.isNotBlank(usernameInput)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNameEqualTo(usernameInput);
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            model.addAttribute("currentUser", userDOList.get(0));
            request.getSession().setAttribute("currentUserId", userDOList.get(0).getUserId());
            if(StringUtils.isNotBlank(passwdInput)){
                String mdPwd = MyMD5Util.code(passwdInput);
            }
        }
    }
}
