package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.core.business.abstracts.MessageService;
import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.entity.Category;
import com.turkcell.ecommerce.repository.CategoryRepository;
import com.turkcell.ecommerce.service.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;
    private MessageService messageService;

    public void categoryNameCannotBeDuplicated(String name) {
        Optional<Category> category = categoryRepository.findByNameIgnoreCase(name);
        if (category.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CATEGORY_NAME_EXISTS));
        }
    }

    public void categoryIdExists(int categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CATEGORY_NOT_FOUND));
        }
    }

    public void parentCategoryIdExists(int parentCategoryId) {
        if (parentCategoryId != 0) {
            Optional<Category> category = categoryRepository.findById(parentCategoryId);
            if (!category.isPresent()) {
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.PARENT_CATEGORY_NOT_FOUND));
            }
        }
    }

    public void checkcategoryAssociatedWithAnyProduct(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CATEGORY_NOT_FOUND));
        }
        if (!category.get().getProducts().isEmpty()) {
            throw new BusinessException("There are products associated with the category.");
        }
    }
}
