package cn.itcast.order.client;

import cn.itcast.order.pojo.User;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userClient",
        url = "http://localhost:8081",
        fallback = UserClientFallback.class
)
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);

//    测试这么写   会不会导致  异常过多不触发熔断  or  触发熔断、限流  但是走走这里的catch逻辑，不走fallback逻辑
    default User getUserById(Long id){
        try {
            return getUser(id);
        }catch (FeignException feignException){
            User user = new User();
            user.setId(1111111L);
            user.setUsername("来自try-catch而不是fallback");
            return user;
        }
    }
}
