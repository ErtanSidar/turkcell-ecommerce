package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.dtos.BasketItemList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBusinessRules {

    private ProductRepository productRepository;

    public void checkAssociatedWithAnyProduct(int id) {
        List<Product> products = productRepository.findAllProductsByCategoryId(id);
        if (!products.isEmpty()) {
            throw new BusinessException("There are products associated with the category.");
        }
    }

    public void productNameCannotBeDuplicated(int id, String name) {
        Product product = productRepository.findById(id).get();
        if (product.getName().equalsIgnoreCase(name)) {
            throw new BusinessException("Product name cannot be duplicated.");
        }
    }

    public void checkProductStock(List<BasketItemList> basketItems) {
        for (BasketItemList basketItem : basketItems) {
            checkProductStock2(basketItem.getProductId(), basketItem.getQuantity());
        }
    }

    public void checkProductStock2(int productId, int quantity) {
        Product product = productRepository.findById(productId).get();
        if (product.getStock() < quantity) {
            throw new BusinessException(product.getName() +"'s stock is not enough.");
        }
    }
}
