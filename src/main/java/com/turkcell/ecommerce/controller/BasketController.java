package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.dtos.requests.basketRequests.CreateBasketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    public void add(@RequestBody CreateBasketRequest createBasketRequest) {
        basketService.add(createBasketRequest);
    }

    @GetMapping
    public List<Basket> getAll() {
        return basketService.getAll();
    }


}
