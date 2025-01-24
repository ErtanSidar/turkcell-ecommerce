package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.product.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.product.UpdateProductRequest;
import com.turkcell.ecommerce.service.rules.CategoryBusinessRules;
import com.turkcell.ecommerce.service.rules.ProductBusinessRules;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {

        categoryBusinessRules.categoryIdExists(createProductRequest.getCategoryId());
        productBusinessRules.productNameCannotBeDuplicated(createProductRequest.getName());

        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setStock(createProductRequest.getStock());
        product.setImageUrl(createProductRequest.getImageUrl());

        Category category = new Category();
        category.setId(createProductRequest.getCategoryId());

        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest, int id) {
        productBusinessRules.productNameCannotBeDuplicatedForUpdate(id, updateProductRequest.getName());

        Product product = productRepository.findById(id).get();

        product.setName(updateProductRequest.getName());
        product.setStock(updateProductRequest.getStock());

        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productBusinessRules.checkProductAssociatedWithAnyOrder(id);
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProducts(Integer categoryId, Double minPrice, Double maxPrice, Boolean isIntock) {
        return productRepository.filterProducts(categoryId, minPrice, maxPrice, isIntock);
    }

    @Override
    public void updateProductQuantity(int productId, int quantity) {
        Product product = productRepository.findById(productId).get();
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }
}
