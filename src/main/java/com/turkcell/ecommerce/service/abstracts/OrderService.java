package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.service.dtos.requests.orderRequests.CreateOrderRequest;

public interface OrderService {
    void add(CreateOrderRequest createOrderRequest);
}
