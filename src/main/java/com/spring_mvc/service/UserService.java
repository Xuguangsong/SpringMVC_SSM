package com.spring_mvc.service;

import com.spring_mvc.dao.UserMapper;
import com.spring_mvc.pojo.User;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
@Controller
public class UserService {
    @Resource
    private UserMapper userMapper;


    public User getUser(int id){
        User a=this.userMapper.selectByPrimaryKey(id);
        if(a!=null){
            return a;
        }
        return null;
    }

    public int insertUser(User user){
        return this.userMapper.insert(user);
    }
}
