package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.repository.CategoryRepository;
import com.hoangtiot.report.service.CategoryService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllAvailable() {
        // find available
        return categoryRepository.findAll().stream().filter(c -> !c.isDisable()).toList();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean addCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        category.setDisable(false);
        categoryRepository.save(category);

        return true;
    }

    @Override
    public boolean updateCategory(String newName, int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(newName);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDisableCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setDisable(!category.isDisable());
            categoryRepository.save(category);
            return true;
        }
        return false;
    }
}
