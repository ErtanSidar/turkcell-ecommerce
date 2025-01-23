package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.service.abstracts.OrderService;
import com.turkcell.ecommerce.service.dtos.order.CreateOrderRequest;
import com.turkcell.ecommerce.service.dtos.order.UpdateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Order getById(@RequestParam int id) {
        return orderService.getById(id);
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public void add(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.add(createOrderRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateOrderRequest updateOrderRequest, @RequestParam int id) {
        orderService.update(updateOrderRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        orderService.delete(id);
    }
}
