package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.dtos.basket.CreateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basket.UpdateBasketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping
    public Basket getById(@RequestParam int id) {
        return basketService.getById(id);
    }

    @GetMapping("/all")
    public List<Basket> getAll() {
        return basketService.getAll();
    }

    @PostMapping
    public void add(@RequestBody CreateBasketRequest createBasketRequest) {
        basketService.add(createBasketRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBasketRequest updateBasketRequest, @RequestParam int id) {
        basketService.update(updateBasketRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        basketService.delete(id);
    }


}
