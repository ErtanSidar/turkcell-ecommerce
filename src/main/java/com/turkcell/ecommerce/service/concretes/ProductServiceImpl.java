package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.ProductRepository;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.UpdateProductRequest;
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
    public List<Product> findProducts(String category, Double minPrice, Double maxPrice, Integer minStock) {
        return Collections.emptyList();
    }


    @Override
    public Product getById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {

        categoryBusinessRules.categoryIdExists(createProductRequest.getCategoryId());

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
    public void update(int id, UpdateProductRequest updateProductRequest) {

        productBusinessRules.productNameCannotBeDuplicated(id, updateProductRequest.getName());

        Product product = productRepository.findById(id).get();

        product.setName(updateProductRequest.getName());
        product.setStock(updateProductRequest.getStock());

        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
