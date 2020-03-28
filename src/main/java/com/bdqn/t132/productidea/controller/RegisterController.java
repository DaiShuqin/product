package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.pojo.shopvcode;
import com.bdqn.t132.productidea.service.ShopUserService;
import com.bdqn.t132.productidea.service.shopvcodeService;
import com.bdqn.t132.productidea.util.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private ShopUserService shopUserService;

    @Autowired
    private shopvcodeService shopvcodeService;
    @RequestMapping("/")
    public Map register(ShopUser shopUser, HttpSession session){
        System.out.println("--------------------------");
        //调用service去登录的校验
        Map retMap = new HashMap();
        System.out.println("---------------------"+shopUser.getPassword());
        shopvcode shopvcode1 = (shopvcode) session.getAttribute("shopvcode");
        if (shopUserService.selectByUser(shopUser)==null){
            if(shopUser.getPassword().length()>=6) {
                if (shopUser.getPassword().length() <= 16) {
                    if (shopUser.getPhoneno().length() == 11) {
                        if(shopvcodeService.selectvcode(shopvcode1)!=null){
                            if(shopvcodeService.selectvcodeTime(shopvcode1)==null){
                                shopUser.setCreateTime(new Date());
                                shopUser.setUserBalance(1000l);
                                shopUser.setPassword(Md5Utils.hash(shopUser.getPassword()));
                                int num = shopUserService.insertSelective(shopUser);
                                if (num > 0) {
                                    retMap.put("retCode", "666");
                                    retMap.put("MsgCode", "注册成功");
                                } else {
                                    retMap.put("retCode", "444");
                                    retMap.put("MsgCode", "注册失败");
                                }
                            }else{
                                shopvcode shopvcode = new shopvcode();
                                shopvcode.setIsno(0);
                                shopvcode.setVcode(shopUser.getVcode());
                                shopvcodeService.updateByPrimaryKeySelectiveVcode(shopvcode);
                                retMap.put("retCode","557");
                                retMap.put("MsgCode","验证码已过期");
                            }
                        }else{
                            retMap.put("retCode","557");
                            retMap.put("MsgCode","验证码不正确");
                        }

                    } else {
                        retMap.put("retCode", "556");
                        retMap.put("MsgCode", "手机号格式输入错误");
                    }
                }else{
                    retMap.put("retCode","555");
                    retMap.put("MsgCode","密码必须小于等于16位");
                }
            }else{
                retMap.put("retCode","555");
                retMap.put("MsgCode","密码必须大于等于6位");
            }
        }else{
            retMap.put("retCode","777");
            retMap.put("MsgCode","该用户已被注册");
        }

        return retMap;
    }

    @RequestMapping("/vcode")
    public Map ObtainVcode(shopvcode shopvcode,HttpSession session){
        session.setAttribute("shopvcode",shopvcode);
        Map map=new HashMap();
        System.out.println("---------------------"+shopvcode.getTelephone());
        //查询电话是否被注册过,如果未被注册,返回该电话未被用户注册,请注册.

        if(shopvcode.getTelephone().length()==11){
            Integer num = (int) (Math.random()*(9999-1000)+1000);
            System.out.println("--------------------"+num);
            shopvcode.setCreateTime(new Date());
            shopvcode.setVcode(num.toString());
            int nn = shopvcodeService.insertSelective(shopvcode);
            if (nn>0){

                System.out.println("-------------------验证码发送成功");
            }else{
                System.out.println("-------------------验证码发送失败");
            }
        }else{
            map.put("retCode","400");
            map.put("MsgCode","手机号格式不正确,请重新输入");
        }


        return map;

    }
}
