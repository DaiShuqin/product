package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.pojo.SlideShow;
import com.bdqn.t132.productidea.service.SlideShowService;
import com.bdqn.t132.productidea.service.WmOprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 */
@CrossOrigin
@RestController
@RequestMapping("/slideshow")
public class SlideController {
    @Autowired
    SlideShowService slideShowService;
    @RequestMapping("/list")
    public Object nn(HttpSession session){
        Map map=new HashMap();
        List<SlideShow> list=slideShowService.selectslidelist();
        map.put("retCode","1000");
        map.put("retData",list);
        return map;
    }
}
