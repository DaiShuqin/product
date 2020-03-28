package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.ShopUser;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface ShopUserService {
    int deleteByPrimaryKey(Integer id);
    ShopUser selectByuserphone(String phone);
    int insert(ShopUser record);
    Map doLogin(ShopUser user);
    int insertSelective(ShopUser record);
    public ShopUser getShopUser(String userName);
    ShopUser selectByPrimaryKey(Integer id);
    ShopUser selectByUser(ShopUser user);
    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);


}
