package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.OrderItem;
import com.turkcell.ecommerce.repository.OrderItemRepository;
import com.turkcell.ecommerce.service.abstracts.OrderItemService;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.UpdateOrderItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;


    @Override
    public OrderItem getById(int id) {
        return null;
    }

    @Override
    public List<OrderItem> getAll() {
        return List.of();
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {

    }

    @Override
    public void update(UpdateOrderItemRequest updateOrderItemRequest, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
