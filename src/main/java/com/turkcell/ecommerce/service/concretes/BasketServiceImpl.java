package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.entity.Basket;
import com.turkcell.ecommerce.entity.BasketDetail;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.BasketRepository;
import com.turkcell.ecommerce.service.abstracts.BasketService;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.requests.basketRequests.CreateBasketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    @Override
    public void add(CreateBasketRequest createBasketRequest) {

        List<BasketDetail> basketDetails = createBasketRequest.getBasketDetails();
        UUID uuid = UUID.randomUUID();
        for (BasketDetail basketDetail : basketDetails) {
            Product product = productService.getById(basketDetail.getProductId());
            if (product.getStock() < basketDetail.getAmount()) {
                throw new BusinessException("Ürün stoğu yetersiz.");
            }

            updateProductStock(product, basketDetail.getAmount());

            Basket basket = new Basket();
            basket.setBasketId(uuid);
            basket.setName(product.getName());
            basket.setPrice(product.getPrice());
            basket.setAmount(basketDetail.getAmount());
            basket.setTotalPrice(basketDetail.getAmount() * product.getPrice());
            basketRepository.save(basket);
        }

    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public List<Basket> getAllByBasketId(UUID basketId) {
        return basketRepository.findAllByBasketId(basketId);
    }

    private void updateProductStock(Product product, int amount) {
        product.setStock(product.getStock() - amount);
        productService.save(product);
    }
}
