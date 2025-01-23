package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findBasketByUserId(int userId);
}
