package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.product.CreateProductRequest;
import com.turkcell.ecommerce.service.dtos.product.UpdateProductRequest;
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
    public Product getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        productService.add(createProductRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateProductRequest updateProductRequest, @RequestParam int id) {
        productService.update(updateProductRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        productService.delete(id);
    }

    @GetMapping("/find")
    public List<Product> findProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean isInStock
    ) {
        return productService.findProducts(categoryId, minPrice, maxPrice, isInStock);
    }
}
