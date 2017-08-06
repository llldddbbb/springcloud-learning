package com.ldb.springcloud.controller;

import com.ldb.springcloud.dao.UserRepository;
import com.ldb.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        User findOne=this.userRepository.findOne(id);
        System.out.println("user");
        return findOne;
    }

}
