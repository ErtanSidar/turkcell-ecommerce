package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.BasketItem;
import com.turkcell.ecommerce.service.abstracts.BasketItemService;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.dtos.basket.CreateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basket.UpdateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basketItem.CreateBasketItemRequest;
import com.turkcell.ecommerce.service.dtos.basketItem.UpdateBasketItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final BasketItemService basketItemService;

    @GetMapping("/basket")
    public Basket getByIdBasket(@RequestParam int id) {
        return basketService.getById(id);
    }

    @GetMapping("/basket-item")
    public BasketItem getByIdBasketItem(@RequestParam int id) {
        return basketItemService.getById(id);
    }

    @GetMapping("/basket/all")
    public List<Basket> getAllBaskets() {
        return basketService.getAll();
    }

    @GetMapping("/basket-item/all")
    public List<BasketItem> getAllBasketItems() {
        return basketItemService.getAll();
    }

    @PostMapping("/basket")
    public void addBasket(@RequestBody CreateBasketRequest createBasketRequest) {
        basketService.add(createBasketRequest);
    }

    @PostMapping("/basket-item")
    public void addBasketItem(@RequestBody CreateBasketItemRequest createBasketItemRequest) {
        basketItemService.add(createBasketItemRequest);
    }

    @PutMapping("/basket")
    public void updateBasket(@RequestBody UpdateBasketRequest updateBasketRequest, @RequestParam int id) {
        basketService.update(updateBasketRequest, id);
    }

    @PutMapping("/basket-item")
    public void updateBasketItem(@RequestBody UpdateBasketItemRequest updateBasketItemRequest, @RequestParam int id) {
        basketItemService.update(updateBasketItemRequest, id);
    }

    @DeleteMapping("/basket")
    public void deleteBasket(@RequestParam int id) {
        basketService.delete(id);
    }

    @DeleteMapping("/basket-item")
    public void deleteBasketItem(@RequestParam int id) {
        basketItemService.delete(id);
    }


}
