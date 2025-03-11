package cn.itcast.order.client;

import cn.itcast.order.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(6666666L);
        user.setUsername("来自fallback生效");
        return user;
    }
}
