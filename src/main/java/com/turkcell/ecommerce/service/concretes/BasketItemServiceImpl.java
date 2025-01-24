package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.BasketItem;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.BasketItemRepository;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.abstracts.BasketItemService;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.BasketItemList;
import com.turkcell.ecommerce.service.dtos.basketItem.CreateBasketItemRequest;
import com.turkcell.ecommerce.service.dtos.basketItem.UpdateBasketItemRequest;
import com.turkcell.ecommerce.service.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;
    private final ProductBusinessRules productBusinessRules;
    private final ProductRepository productRepository;
    private final ProductService productService;


    @Override
    public BasketItem getById(int id) {
        return basketItemRepository.findById(id).get();
    }

    @Override
    public List<BasketItem> getAll() {
        return basketItemRepository.findAll();
    }

    @Override
    public void add(CreateBasketItemRequest createBasketItemRequest) {

        productBusinessRules.checkProductStock(createBasketItemRequest.getBasketItems());

        List<BasketItem> basketItems = isProductAvailableInBasket(createBasketItemRequest.getBasketId(), createBasketItemRequest.getBasketItems());

        basketItemRepository.saveAll(basketItems);
    }

    @Override
    public void update(UpdateBasketItemRequest updateBasketItemRequest, int id) {
        BasketItem basketItem = basketItemRepository.findById(id).get();
        basketItem.setQuantity(updateBasketItemRequest.getProductQuantity());
        basketItem.setTotalPrice(basketItem.getProduct().getPrice() * updateBasketItemRequest.getProductQuantity());
        basketItemRepository.save(basketItem);
    }

    @Override
    public void delete(int id) {
        basketItemRepository.deleteById(id);
    }

    @Override
    public List<BasketItem> findBasketItemByBasketId(int basketId) {
        return basketItemRepository.findBasketItemByBasketId(basketId);
    }

    private List<BasketItem> isProductAvailableInBasket(int basketId, List<BasketItemList> basketItemList) {
        List<BasketItem> basketItems = new ArrayList<>();
        for (BasketItemList basketItemL : basketItemList) {
            BasketItem basketItem = basketItemRepository.getBasketItemByBasketIdAndProductId(basketId, basketItemL.getProductId());
            if (basketItem != null) {
                int newQuantity = basketItem.getQuantity() + basketItemL.getQuantity();
                basketItem.setQuantity(newQuantity);
                basketItem.setTotalPrice(basketItem.getProduct().getPrice() * newQuantity);
            } else {
                basketItem = new BasketItem();
                Basket basket = new Basket();
                basket.setId(basketId);

                Product product = productService.getById(basketItemL.getProductId());

                basketItem.setBasket(basket);
                basketItem.setProduct(product);
                basketItem.setQuantity(basketItemL.getQuantity());
                basketItem.setTotalPrice(product.getPrice() * basketItemL.getQuantity());
            }
            basketItems.add(basketItem);
        }

        return basketItems;
    }


}
