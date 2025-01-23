package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.repository.OrderRepository;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.abstracts.OrderService;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.order.UpdateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BasketService basketService;


    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {

    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
