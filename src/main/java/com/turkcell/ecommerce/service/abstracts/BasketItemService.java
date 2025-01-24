package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.BasketItem;
import com.turkcell.ecommerce.service.dtos.basketItem.CreateBasketItemRequest;
import com.turkcell.ecommerce.service.dtos.basketItem.UpdateBasketItemRequest;

import java.util.List;

public interface BasketItemService {
    BasketItem getById(int id);

    List<BasketItem> getAll();

    void add(CreateBasketItemRequest createBasketItemRequest);

    void update(UpdateBasketItemRequest updateBasketItemRequest, int id);

    void delete(int id);

    List<BasketItem> findBasketItemByBasketId(int basketId);
}
