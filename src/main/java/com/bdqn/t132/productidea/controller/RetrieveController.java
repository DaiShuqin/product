package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.pojo.shopvcode;
import com.bdqn.t132.productidea.service.ShopUserService;
import com.bdqn.t132.productidea.service.shopvcodeService;
import com.bdqn.t132.productidea.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/retrieve")
public class RetrieveController {
    @Autowired
    private ShopUserService shopUserService;

    @Autowired
    private shopvcodeService shopvcodeService;
    @RequestMapping("/retrievename")
    public Map register(shopvcode shopvcode, HttpSession session){
        Map map = new HashMap();
        System.out.println("--------"+shopvcode.getTelephone());
        //查询验证码是否正确
        if(shopUserService.selectByuserphone(shopvcode.getTelephone())==null){
            map.put("retCode","400");
            map.put("MsgCode","该手机未被注册,请输入正确手机号");
        }else {
            if (shopvcodeService.selectvcode(shopvcode) == null) {
                map.put("retCode", "500");
                map.put("MsgCode", "验证码输入错误");
            } else {
                if (shopvcodeService.selectvcodeTime(shopvcode) == null) {
                    map.put("retCode", "666");
                    map.put("MsgCode", "验证正确,请输入新的用户名");
                } else {
                    shopvcode shopvcode1 = new shopvcode();
                    shopvcode1.setIsno(0);
                    shopvcode1.setVcode(shopvcode.getVcode());
                    shopvcodeService.updateByPrimaryKeySelectiveVcode(shopvcode1);
                    map.put("retCode", "500");
                    map.put("MsgCode", "验证码已过期");
                }
            }
        }
        return map;
    }

    @RequestMapping("/updateusername")
    public Map updateusername(ShopUser shopUser){
        Map map = new HashMap();
        System.out.println("==============="+shopUser.getUserName());
        if(shopUserService.updateByPrimaryKeySelective(shopUser)>0){
            map.put("MsgCode","修改成功");
            map.put("retCode","666");
        }else{
            map.put("MsgCode","修改失败");
            map.put("retCode","400");
        }
        return map;
    }

    @RequestMapping("/retrievepwd")
    public Map registerpwd(shopvcode shopvcode, HttpSession session){
        Map map = new HashMap();
        System.out.println("--------"+shopvcode.getTelephone());
        //查询验证码是否正确
        if(shopUserService.selectByuserphone(shopvcode.getTelephone())==null){
            map.put("retCode","400");
            map.put("MsgCode","该手机未被注册,请输入正确手机号");
        }else {
            if (shopvcodeService.selectvcode(shopvcode) == null) {
                map.put("retCode", "500");
                map.put("MsgCode", "验证码输入错误");
            } else {
                if (shopvcodeService.selectvcodeTime(shopvcode) == null) {
                    map.put("retCode", "666");
                    map.put("MsgCode", "验证正确,请输入新的用户名");
                } else {
                    shopvcode shopvcode1 = new shopvcode();
                    shopvcode1.setIsno(0);
                    shopvcode1.setVcode(shopvcode.getVcode());
                    shopvcodeService.updateByPrimaryKeySelectiveVcode(shopvcode1);
                    map.put("retCode", "500");
                    map.put("MsgCode", "验证码已过期");
                }
            }
        }
        return map;
    }

    @RequestMapping("/updateuserpwd")
    public Map updateuserpwd(ShopUser shopUser){
        Map map = new HashMap();
        System.out.println("==============="+shopUser.getPassword());
        shopUser.setPassword(Md5Utils.hash(shopUser.getPassword()));
        if(shopUserService.updateByPrimaryKeySelective(shopUser)>0){
            map.put("MsgCode","修改成功");
            map.put("retCode","666");
        }else{
            map.put("MsgCode","修改失败");
            map.put("retCode","400");
        }
        return map;
    }
}
