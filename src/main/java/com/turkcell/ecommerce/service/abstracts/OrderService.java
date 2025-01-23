package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.order.UpdateOrderRequest;

import java.util.List;

public interface OrderService {
    Order getById(int id);
    List<Order> getAll();
    void add(CreateOrderRequest createOrderRequest);
    void update(UpdateOrderRequest updateOrderRequest, int id);
    void delete(int id);
}
