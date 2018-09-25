package com.spring_mvc.service.impl;

import com.spring_mvc.mapper.UserMapper;
import com.spring_mvc.model.User;
import com.spring_mvc.service.api.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public int checkLogin(String name, String password) {
        User user = userMapper.selectByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user.getId();
        }else if (user != null && user.getPassword()!=(password)){
            return -1;
        }else{
            return 0;
        }
    }

    public int register(int id ,String name, String password) {
        userMapper.insert(id,name,password);
        return 0;
    }

    public List<User> alluser() {
        List<User> user = userMapper.allUser();
        return  user;
    }
}
