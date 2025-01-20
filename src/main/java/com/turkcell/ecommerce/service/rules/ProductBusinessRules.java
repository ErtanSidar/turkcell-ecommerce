package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBusinessRules {

    private ProductRepository productRepository;

    public void checkAssociatedWithAnyProduct(int id) {
        List<Product> products = productRepository.findProductByCategoryId(id);
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
}
