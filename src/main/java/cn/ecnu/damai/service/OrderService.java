package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    List<Order> getOrderList(Integer userId);

    Order getOrder(Integer orderId);
}
