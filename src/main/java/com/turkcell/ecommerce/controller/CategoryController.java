package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.service.abstracts.CategoryService;
import com.turkcell.ecommerce.service.dtos.requests.categoryRequests.CreateCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        categoryService.add(createCategoryRequest);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
