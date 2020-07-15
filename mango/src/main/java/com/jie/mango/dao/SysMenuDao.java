package com.jie.mango.dao;

import com.jie.mango.model.SysMenuModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuDao {

    /**
     * 查询所有菜单
     * @return list
     */
    List<SysMenuModel> selectAllMenu();

    /**
     * 根据用户名查询菜单
     * @param username
     * @return list
     */
    List<SysMenuModel> selectMenuByUserName(String username);
}
