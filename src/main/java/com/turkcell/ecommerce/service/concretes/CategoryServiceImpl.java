package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.CategoryRepository;
import com.turkcell.ecommerce.service.abstracts.CategoryService;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.category.CreateCategoryRequest;
import com.turkcell.ecommerce.service.dtos.category.UpdateCategoryRequest;
import com.turkcell.ecommerce.service.rules.CategoryBusinessRules;
import com.turkcell.ecommerce.service.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final ProductBusinessRules productBusinessRules;
    private final ProductService productService;

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {

        categoryBusinessRules.categoryNameCannotBeDuplicated(createCategoryRequest.getName());
        categoryBusinessRules.parentCategoryIdExists(createCategoryRequest.getParentId());

        Category category = new Category();
        category.setName(createCategoryRequest.getName());

        Category parentCategory = new Category();
        parentCategory.setId(createCategoryRequest.getParentId());

        category.setParentCategory(parentCategory);

        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryBusinessRules.checkcategoryAssociatedWithAnyProduct(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest, int id) {

    }
}
