package com.jie.mango.controller;

import com.jie.mango.response.SysUserResponse;
import com.jie.mango.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Component
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询用户信息
     * @return
     */
    @PostMapping("/findSysUser")
    public SysUserResponse findSysUserInfo() {
        return sysUserService.findSysUserInfo();
    }
}
