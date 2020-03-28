package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.ShopUserMapper;
import com.bdqn.t132.productidea.pojo.ShopUser;
import com.bdqn.t132.productidea.service.ShopUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private ShopUserMapper shopUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public ShopUser selectByuserphone(String phone) {
        return shopUserMapper.selectByuserphone(phone);
    }

    @Override
    public int insert(ShopUser record) {
        return 0;
    }

    @Override
    public Map doLogin(ShopUser user) {
        Map map = new HashMap();
        map.put("retCode","1000");
        map.put("retMsg","登录成功");
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(user.getUserName(),user.getPassword()));
            map.put("user",subject.getPrincipal());
            //rabbitTemplate.convertAndSend("OperLogExchange","OperLogRouting", map);

        }catch (UnknownAccountException un) {
            map.put("retCode", "901");
            map.put("retMsg", "用户不存在");
        }catch (IncorrectCredentialsException in){
            map.put("retCode","901");
            map.put("retMsg","密码错误");
        }
        return map;
    }

    @Override
    public int insertSelective(ShopUser record) {
        return shopUserMapper.insertSelective(record);
    }

    @Override
    public ShopUser getShopUser(String userName) {
        return shopUserMapper.getShopUser(userName);
    }

    @Override
    public ShopUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ShopUser selectByUser(ShopUser user) {
        return shopUserMapper.selectByUser(user);
    }

    @Override
    public int updateByPrimaryKeySelective(ShopUser record) {
        return shopUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ShopUser record) {
        return 0;
    }
}
