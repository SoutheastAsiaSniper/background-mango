package com.jie.mango.service.impl;

import com.jie.mango.common.SysConstants;
import com.jie.mango.dao.SysMenuDao;
import com.jie.mango.model.SysMenuModel;
import com.jie.mango.response.SysMenuResponse;
import com.jie.mango.response.SysUserResponse;
import com.jie.mango.service.SysMenuService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Log4j
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 查处所有菜单
     * @return
     */
    @Override
    public SysMenuResponse selectAllMenu() {
        SysMenuResponse response = new SysMenuResponse();
        response.setRejCode("000000");
        response.setRejMsg("交易成功");
        List<SysMenuModel> list = sysMenuDao.selectAllMenu();
        response.setMenuList(list);
        return response;
    }

    /**
     * 根据用户名查询菜单
     * @param username
     * @return
     */
    @Override
    public SysMenuResponse selectMenuByUserName(String username, int menuType) {
        SysMenuResponse response = new SysMenuResponse();
        response.setRejCode("000000");
        response.setRejMsg("交易成功");
        List<SysMenuModel> sysMenus = new ArrayList<>();
        List<SysMenuModel> menus = new ArrayList<>();
        //根据用户查出菜单 管理员具有所有菜单权限
        if (username == null || "".equals(username) || SysConstants.ADMIN.equals(username)){
            menus = sysMenuDao.selectAllMenu();
        }else{
            menus = sysMenuDao.selectMenuByUserName(username);
        }
        //查处父菜单
        for (SysMenuModel menu : menus){
            if (menu.getParentId() == null || menu.getParentId() == 0){
                if (!sysMenus.contains(menu)){
                    sysMenus.add(menu);
                }
            }
        }
        //排序
        sysMenus.sort((o1,o2) -> o1.getOrderBy().compareTo(o2.getOrderBy()));
        findChildren(sysMenus, menus, menuType);
        response.setMenuList(sysMenus);
        return response;
    }

    /**
     * 找出子菜单
     * @param sysMenus
     * @param menus
     * @param menuType
     */
    private void findChildren(List<SysMenuModel> sysMenus, List<SysMenuModel> menus, int menuType){
        for (SysMenuModel sysMenu : sysMenus){
            List<SysMenuModel> children = new ArrayList<>();
            for (SysMenuModel menu : menus){
                if(menuType == 1 && menu.getType() == 2){
                    //如果获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())){
//                    menu.setName(sysMenu.getName());
                    if(!children.contains(menu)){
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort((o1,o2) -> o1.getOrderBy().compareTo(o2.getOrderBy()));
            findChildren(children, menus, menuType);
        }
    }
}
