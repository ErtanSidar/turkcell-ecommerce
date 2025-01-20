package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.service.dtos.requests.basketRequests.CreateBasketRequest;

import java.util.List;
import java.util.UUID;

public interface BasketService {

    void add(CreateBasketRequest createBasketRequest);

    List<Basket> getAll();

    List<Basket> getAllByBasketId(UUID basketId);
}
