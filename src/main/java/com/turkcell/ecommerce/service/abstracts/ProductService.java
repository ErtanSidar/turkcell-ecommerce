package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    Product getById(int id);
    void add(CreateProductRequest createProductRequest);
    void update(int id, UpdateProductRequest updateProductRequest);

    List<Product> findProducts(String category, Double minPrice, Double maxPrice, Integer minStock);

    void delete(int id);

    void save(Product product);
}
