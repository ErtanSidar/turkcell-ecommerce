package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.entity.OrderStatus;
import com.turkcell.ecommerce.repository.OrderRepository;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.abstracts.OrderService;
import com.turkcell.ecommerce.service.dtos.requests.orderRequests.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BasketService basketService;

    @Override
    public void add(CreateOrderRequest createOrderRequest) {

        Order order = new Order();
        order.setOrderNumber(123456789);
        order.setStatus(OrderStatus.PREPARING);
        order.setOrderDate(LocalDateTime.now());

        Basket basket = new Basket();
        basket.setId(9);
        basket.setBasketId(createOrderRequest.getBasketId());
        order.setBasket(basket);

        orderRepository.save(order);

    }
}
