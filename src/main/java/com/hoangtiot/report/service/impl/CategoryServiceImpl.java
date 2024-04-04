package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.repository.CategoryRepository;
import com.hoangtiot.report.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
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
    public boolean addCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean disableCategory(Category category) {
        category.setDisable(true);
        categoryRepository.save(category);
        return true;
    }
}
