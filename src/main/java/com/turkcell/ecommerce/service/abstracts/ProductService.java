package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.service.dtos.product.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.product.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    Product getById(int id);
    List<Product> getAll();
    void add(CreateProductRequest createProductRequest);
    void update(UpdateProductRequest updateProductRequest, int id);
    void delete(int id);
    List<Product> findProducts(Integer categoryId, Double minPrice, Double maxPrice, Boolean isIntock);

    void updateProductQuantity(int productId, int quantity);
}
