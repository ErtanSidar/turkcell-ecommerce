package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.service.dtos.category.CreateCategoryRequest;
import com.turkcell.ecommerce.service.dtos.category.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    Category getById(int id);
    List<Category> getAll();
    void add(CreateCategoryRequest createCategoryRequest);
    void update(UpdateCategoryRequest updateCategoryRequest, int id);
    void delete(int id);
}
