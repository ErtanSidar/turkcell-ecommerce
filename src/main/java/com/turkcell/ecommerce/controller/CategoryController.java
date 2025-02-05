package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.service.abstracts.CategoryService;
import com.turkcell.ecommerce.service.dtos.category.CreateCategoryRequest;
import com.turkcell.ecommerce.service.dtos.category.UpdateCategoryRequest;
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
    public Category getById(@RequestParam int id) {
        return categoryService.getById(id);
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        categoryService.add(createCategoryRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest, @RequestParam int id) {
        categoryService.update(updateCategoryRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        categoryService.delete(id);
    }
}
