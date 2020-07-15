package com.jie.mango.dao;

import com.jie.mango.model.SysUserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysUserDao {
    /**
     * 查询用户信息
     *
     * @return
     */
    List<SysUserModel> findSysUserInfo();

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    SysUserModel findSysUserInfoByName(@Param("name") String name);
}
