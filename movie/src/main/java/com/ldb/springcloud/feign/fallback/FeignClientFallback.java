package com.ldb.springcloud.feign.fallback;

import com.ldb.springcloud.feign.UserFeignClient;
import com.ldb.springcloud.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(int id) {
        User user=new User();
        user.setId(-1);
        user.setName("默认账户");
        return user;
    }

    @Override
    public User get1(int id, String username) {
        return null;
    }

    @Override
    public User get2(Map<String, Object> map) {
        return null;
    }

    @Override
    public User post(User user) {
        return null;
    }
}
