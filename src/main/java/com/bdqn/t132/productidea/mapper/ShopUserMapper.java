package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.ShopUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface ShopUserMapper {
    int deleteByPrimaryKey(Integer id);
    ShopUser selectByuserphone(String phone);
    int insert(ShopUser record);
    ShopUser getShopUser(String userName);
    int insertSelective(ShopUser record);
    ShopUser selectByUser(ShopUser user);
    ShopUser selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);
}