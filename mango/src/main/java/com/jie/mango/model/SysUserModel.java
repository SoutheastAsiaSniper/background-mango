package com.jie.mango.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
public class SysUserModel {
    /**
     *用户编号
     */
    private BigInteger userseq;

    /**
     *用户名
     */
    private String name;

    /**
     *昵称
     */
    private String nickName;

    /**
     *头像
     */
    private String avatar;

    /**
     *密码
     */
    private String password;

    /**
     *加密盐
     */
    private String salt;

    /**
     *邮箱
     */
    private String email;

    /**
     *手机号
     */
    private String mobile;

    /**
     *状态 0：禁用  1：正常
     */
    private String status;

    /**
     *机构id
     */
    private String deptId;

    /**
     *创建人
     */
    private String createBy;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新人
     */
    private String lastUpdateBy;

    /**
     *更新时间
     */
    private Date lastUpdateTime;

    /**
     *是否删除 -1：已删除 0：正常
     */
    private String delFlag;

}
