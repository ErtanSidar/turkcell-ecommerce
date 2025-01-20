package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.requests.productRequests.UpdateProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minStock
    ) {
        return productService.findProducts(category, minPrice, maxPrice, minStock);
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        productService.add(createProductRequest);
    }

    @PutMapping
    public void update(@RequestParam int id, @RequestBody @Valid UpdateProductRequest updateProductRequest) {
        productService.update(id, updateProductRequest);
    }
}
