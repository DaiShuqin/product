package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.service.ShopUserService;
import com.bdqn.t132.productidea.util.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ShopUserService shopUserService;

    @RequestMapping("/")
    public Map doLogin(ShopUser shopUser, HttpSession session){
        System.out.println("============="+shopUser.getPhoneno());
        session.setAttribute("shopuser",shopUser);
        //调用service去登录的校验
        shopUser.setPassword(Md5Utils.hash(shopUser.getPassword()));
        Map retMap = shopUserService.doLogin(shopUser);
        ShopUser user_ = (ShopUser) SecurityUtils.getSubject().getPrincipal();
        session.setAttribute("loginUser",user_.getId());
        //如果登录成功,则将用户信息存入session
        if(retMap.get("retCode").equals("1000")){
            session.setAttribute("user",retMap.get("user"));
        }
        return retMap;
    }
    @RequestMapping("/header")
    public Object nn(HttpSession session){
        Map map=new HashMap();
        ShopUser user=(ShopUser) session.getAttribute("user");
        if(user==null){
            map.put("retCode","500");
            return map;
        }
        map.put("retCode","1000");
        map.put("retData",user);
        return map;
    }
    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        Map map=new HashMap();
        session.removeAttribute("user");
//        Subject subject = getSubject(request, response);
//
//        String redirectUrl = getRedirectUrl(request, response, subject);
//
//        try {
//
//            subject.logout();
//
//        } catch (SessionException ise) {
//
//            ise.printStackTrace();
//
//        }
//
//        issueRedirect(request, response, redirectUrl);
        map.put("retCode","1000");
        return map;
    }
}
