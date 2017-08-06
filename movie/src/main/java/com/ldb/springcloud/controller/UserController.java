package com.ldb.springcloud.controller;

import com.ldb.springcloud.feign.UserFeignClient;
import com.ldb.springcloud.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    // @GetMapping("/user/{id}")
    // public User findById(@PathVariable int id){
    //     return this.restTemplate.getForObject("http://provider-user/"+id,User.class);
    // }


    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable int id){
        return userFeignClient.findById(id);
    }

    public User findByIdFallback(int id){
        User user=new User();
        user.setId(-1);
        user.setName("默认账户");
        return user;
    }

    @GetMapping("/user")
    public User get2(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("username","张三");
        return userFeignClient.get2(map);
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return userFeignClient.post(user);
    }


}
