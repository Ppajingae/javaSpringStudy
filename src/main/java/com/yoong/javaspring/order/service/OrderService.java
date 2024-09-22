package com.yoong.javaspring.order.service;

import com.yoong.javaspring.order.entity.Order;

public interface OrderService {

    Order createOrder(Long id, String itemName, int itemPrice);
}
