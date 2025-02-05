package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.repository.BasketRepository;
import com.turkcell.ecommerce.service.abstracts.BasketItemService;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.abstracts.UserService;
import com.turkcell.ecommerce.service.dtos.basket.CreateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basket.UpdateBasketRequest;
import com.turkcell.ecommerce.service.dtos.basketItem.CreateBasketItemRequest;
import com.turkcell.ecommerce.service.rules.UserBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final BasketItemService basketItemService;
    private final UserBusinessRules userBusinessRules;
    private final ProductService productService;

    @Override
    public Basket getById(int id) {
        return basketRepository.findById(id).get();
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public void add(CreateBasketRequest createBasketRequest) {

        userBusinessRules.checkUserExists(createBasketRequest.getUserId());

        int basketId = 0;

        Basket basketByUserId = basketRepository.findBasketByUserId(createBasketRequest.getUserId());

        if (basketByUserId != null) {
            basketId = basketByUserId.getId();
        } else {
            Basket basket = new Basket();

            User user = new User();
            user.setId(createBasketRequest.getUserId());

            basket.setUser(user);
            Basket savedBasket = basketRepository.save(basket);
            basketId = savedBasket.getId();
        }

        CreateBasketItemRequest createBasketItemRequest = new CreateBasketItemRequest();
        createBasketItemRequest.setBasketId(basketId);
        createBasketItemRequest.setBasketItems(createBasketRequest.getBasketItems());

        basketItemService.add(createBasketItemRequest);


    }

    @Override
    public void update(UpdateBasketRequest updateBasketRequest, int id) {

    }

    @Override
    public void delete(int id) {
        basketRepository.deleteById(id);
    }

}
