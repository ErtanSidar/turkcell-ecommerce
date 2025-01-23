package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.service.dtos.basket.CreateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basket.UpdateBasketRequest;

import java.util.List;

public interface BasketService {

    Basket getById(int id);
    List<Basket> getAll();
    void add(CreateBasketRequest createBasketRequest);
    void update(UpdateBasketRequest updateBasketRequest, int id);
    void delete(int id);
}
