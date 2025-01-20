package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.repository.CategoryRepository;
import com.turkcell.ecommerce.service.abstracts.CategoryService;
import com.turkcell.ecommerce.service.dtos.requests.categoryRequests.CreateCategoryRequest;
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

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {

        categoryBusinessRules.categoryNameCannotBeDuplicated(createCategoryRequest.getName());

        Category category = new Category();
        category.setName(createCategoryRequest.getName());
        category.setParentId(createCategoryRequest.getParentId());

        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        productBusinessRules.checkAssociatedWithAnyProduct(id);
        categoryRepository.deleteById(id);
    }
}
