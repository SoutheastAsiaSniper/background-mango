package com.jie.mango.service;

import com.jie.mango.model.SysUserModel;
import com.jie.mango.response.SysUserResponse;

public interface SysUserService {
    /**
     * 查询用户所有信息
     * @return
     */
    SysUserResponse findSysUserInfo();

    /**
     * 根据用户名查询用户信息
     */
    SysUserModel findSysUserInfoByName(String userName);
}
