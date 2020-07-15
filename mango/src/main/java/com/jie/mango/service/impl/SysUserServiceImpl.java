package com.jie.mango.service.impl;

import com.jie.mango.dao.SysUserDao;
import com.jie.mango.model.SysUserModel;
import com.jie.mango.response.SysUserResponse;
import com.jie.mango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查询用户所有信息
     * @return
     */
    @Override
    public SysUserResponse findSysUserInfo() {
        SysUserResponse response = new SysUserResponse();
        response.setRejCode("000000");
        response.setRejMsg("交易成功");
        List<SysUserModel> sysUserModels = sysUserDao.findSysUserInfo();
        response.setFindSysUserInfo(sysUserModels);
        return response;
    }

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    public SysUserModel findSysUserInfoByName(String userName) {
        return sysUserDao.findSysUserInfoByName(userName);
    }
}
