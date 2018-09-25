package com.spring_mvc.service.api;

import com.spring_mvc.model.User;

import java.util.List;

public interface UserService {

    int checkLogin(String name, String password);
    int register(int id,String name, String password);
    List<User> alluser();
}
