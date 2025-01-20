package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    List<Basket> findAllByBasketId(UUID basketId);
}
