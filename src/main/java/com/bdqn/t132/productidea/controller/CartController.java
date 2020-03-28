package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopCart;
import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.service.ShopCartService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ShopCartService shopCartService;
    @RequestMapping("/list/{id}")
    public Map list(@PathVariable Integer id){
        List<ShopCart> list=shopCartService.selectCartList(id);
        Map map=new HashMap();
        map.put("retData",list);
        return map;
    }
    @RequestMapping("/addcart")
    public Map addcart(ShopCart shopCart){
        Map map=new HashMap();
        ShopUser shopUser= (ShopUser) SecurityUtils.getSubject().getPrincipal();
        shopCart.setUserId(shopUser.getId());
        int num=shopCartService.insertSelective(shopCart);
        if(num>0){
            map.put("retCode","1000");
            return map;
        }
        map.put("retCode","500");
        return map;
    }
}

