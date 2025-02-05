package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findOrderItemByProductId(int productId);
}
