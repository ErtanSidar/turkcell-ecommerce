package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.OrderItem;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.CreateOrderItemRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.UpdateOrderItemRequest;

import java.util.List;

public interface OrderItemService {
    OrderItem getById(int id);
    List<OrderItem> getAll();
    void add(CreateOrderItemRequest createOrderItemRequest);
    void update(UpdateOrderItemRequest updateOrderItemRequest, int id);
    void delete(int id);

}
