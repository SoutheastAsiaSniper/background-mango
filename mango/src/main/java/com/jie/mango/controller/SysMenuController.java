package com.jie.mango.controller;

import com.jie.mango.common.SysConstants;
import com.jie.mango.response.SysMenuResponse;
import com.jie.mango.service.SysMenuService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@Log4j
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询所有菜单
     * @return
     */
    @PostMapping("/sys/menuList")
    public SysMenuResponse selectAllMenu(){
        return sysMenuService.selectAllMenu();
    }

    /**
     * 根据用户名查出菜单
     * @param userName
     * @return
     */
    @GetMapping("/sys/findMenuByUsername")
    public SysMenuResponse findMenuByUsername(@RequestParam String userName){
        return sysMenuService.selectMenuByUserName(userName, SysConstants.MENUTYPE);
    }
}
