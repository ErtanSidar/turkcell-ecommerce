package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {

    @Query("SELECT bi FROM BasketItem bi WHERE bi.basket.id = ?1 AND bi.product.id = ?2")
    BasketItem getBasketItemByBasketIdAndProductId(int basketId, int productId);
}
