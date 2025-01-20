package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.service.dtos.requests.categoryRequests.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void add(CreateCategoryRequest createCategoryRequest);

    void delete(int id);
}
