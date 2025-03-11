package cn.itcast.order.web;

import cn.itcast.order.client.UserClient;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Qualifier("cn.itcast.order.client.UserClient")
    @Autowired
    private UserClient userClient  ;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order = Order.builder().id(1L).name("apple").price(6000L).build();

//        User user = userClient.getUser(72L);
        User user = userClient.getUserById(72L);

        order.setUser(user);
        // 3.返回
        return order;
    }
}
