package com.jie.mango.controller;

import com.alibaba.fastjson.JSONObject;
import com.jie.mango.model.SysUserModel;
import com.jie.mango.requests.LoginRequest;
import com.jie.mango.response.LoginAndResResponse;
import com.jie.mango.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Component
public class LoginAndResController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登陆
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public LoginAndResResponse login(@RequestBody LoginRequest request){
        log.info("用户登录开始==================");
        String userName = request.getName();
        String password = request.getPassword();
        SysUserModel user = sysUserService.findSysUserInfoByName(userName);
        LoginAndResResponse resResponse = new LoginAndResResponse();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        log.info("token:======================="+token);
        try {
            subject.login(token);
            resResponse.setRejCode("000000");
            resResponse.setRejMsg("登陆成功");
            resResponse.setToken(subject.getSession().getId());
            resResponse.setUserInfo(user);
        }catch (IncorrectCredentialsException e){
            resResponse.setRejCode("000001");
            resResponse.setRejMsg("密码错误");
        }catch (LockedAccountException e){
            resResponse.setRejCode("000002");
            resResponse.setRejMsg("登陆失败，该账户被冻结");
        }catch (AuthenticationException e){
            resResponse.setRejCode("000003");
            resResponse.setRejMsg("该用户不存在");
        }catch (Exception e){
            e.printStackTrace();
        }
        return resResponse;
    }
}
