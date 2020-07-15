package com.jie.mango.service;

import com.jie.mango.model.SysMenuModel;
import com.jie.mango.response.SysMenuResponse;

import java.util.List;

public interface SysMenuService {

    /**
     * 查询所有菜单
     * @return
     */
    SysMenuResponse selectAllMenu();

    /**
     * 根据用户名查询菜单
     * @return
     */
    SysMenuResponse selectMenuByUserName(String username, int menuType);
}
