package com.example.springboot05mybatis.controller;

import com.example.springboot05mybatis.mapper.UserMapper;
import com.example.springboot05mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        return allUser;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") int id){
        User user = userMapper.getUserById(id);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5, "jojo", "123456"));
        return "message==>addUser ok!";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5, "marry", "29934"));
        return "message==>updateUser ok!";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return "message==>deleteUser ok!";
    }
}
