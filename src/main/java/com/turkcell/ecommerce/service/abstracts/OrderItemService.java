package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.OrderItem;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.UpdateOrderItemRequest;

import java.util.List;

public interface OrderItemService {
    OrderItem getById(int id);
    List<OrderItem> getAll();
    void add(CreateOrderRequest createOrderRequest);
    void update(UpdateOrderItemRequest updateOrderItemRequest, int id);
    void delete(int id);

}
