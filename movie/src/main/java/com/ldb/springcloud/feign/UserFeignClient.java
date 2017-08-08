package com.ldb.springcloud.feign;

import com.ldb.springcloud.feign.fallback.FeignClientFallback;
import com.ldb.springcloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/{id}")
    User findById(@PathVariable("id") int id);

    @GetMapping("/user")
    User get1(@RequestParam("id")int id, @RequestParam("username")String username);

    @GetMapping("/user")
    User get2(@RequestParam Map<String,Object> map);

    @PostMapping("/post")
    User post(@RequestBody User user);
}
