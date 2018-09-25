package com.spring_mvc.mapper;

import com.spring_mvc.model.User;

import java.util.List;

public interface UserMapper {
    User selectByName(String name);
    void insert(int id, String name, String password);
    List<User> allUser();
}