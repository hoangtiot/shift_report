package com.hoangtiot.report.service;

import com.hoangtiot.report.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> findAllAvailable();

    Optional<Category> findById(int id);
    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean disableCategory(Category category);
}
