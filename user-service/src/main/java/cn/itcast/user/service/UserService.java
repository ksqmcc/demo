package cn.itcast.user.service;


import cn.itcast.user.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User queryById(Long id) {
        return User.builder().address("中国").id(1L).username("正常").build();
    }
}