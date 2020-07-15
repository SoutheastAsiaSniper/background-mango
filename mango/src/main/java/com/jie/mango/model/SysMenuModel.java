package com.jie.mango.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class SysMenuModel {

    /**
     *用户编号
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID 一级菜单 0
     */
    private Integer parentId;

    /**
     * 菜单URL，类型 1：普通页面 2：完整嵌套页面 3：嵌套服务页面 iframe
     */
    private String url;

    /**
     * 授权（多个用逗号隔开 如sys:user:add,sys:user:edit）
     */
    private String perms;

    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderBy;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除  -1:删除  0:正常
     */
    private Integer delFlag;

    /**
     * 非数据库字段 子菜单
     */
    private List<SysMenuModel> children;

}
