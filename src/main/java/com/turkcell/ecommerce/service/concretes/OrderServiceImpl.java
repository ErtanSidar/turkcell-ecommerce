package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.BasketItem;
import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.entity.OrderStatus;
import com.turkcell.ecommerce.repository.OrderRepository;
import com.turkcell.ecommerce.service.abstracts.BasketItemService;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.abstracts.OrderItemService;
import com.turkcell.ecommerce.service.abstracts.OrderService;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.order.UpdateOrderRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.CreateOrderItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BasketService basketService;
    private final BasketItemService basketItemService;
    private final OrderItemService orderItemService;


    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
        Basket basket = basketService.getById(createOrderRequest.getBasketId());
        List<BasketItem> basketItems = basketItemService.findBasketItemByBasketId(createOrderRequest.getBasketId());

        double totalPrice = 0;
        for (BasketItem basketItem : basketItems) {
            totalPrice += basketItem.getTotalPrice();
        }

        Order order = new Order();
        order.setUser(basket.getUser());
        order.setOrderNumber("ORDER-" + java.time.LocalDateTime.now() + totalPrice);
        order.setStatus(OrderStatus.PREPARING);
        order.setOrderDate(java.time.LocalDateTime.now());
        order.setTotalAmount(totalPrice);

        Order savedOrder = orderRepository.save(order);

        CreateOrderItemRequest createOrderItemRequest = new CreateOrderItemRequest();
        createOrderItemRequest.setOrderId(savedOrder.getId());
        createOrderItemRequest.setBasketItems(basketItems);


        orderItemService.add(createOrderItemRequest);


    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest, int id) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(updateOrderRequest.getStatus());
        orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}
