package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.service.ShopUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ShopUserService shopUserService;
    @RequestMapping("/info")
    public Map info(HttpSession session){
        Map map=new HashMap();
        ShopUser shopUser=(ShopUser) session.getAttribute("user");
        if(shopUser!=null){
//            System.out.println("=========="+shopUser.getUrl());
            map.put("retCode","1000");
            map.put("retData",shopUser);
            return map;
        }
        map.put("retCode","500");
        return map;
    }
}
