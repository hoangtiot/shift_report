package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll(){

        return ResponseEntity.ok().body(categoryService.findAllAvailable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable int id){
        return ResponseEntity.ok().body(categoryService.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok().body(category.getName());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.ok().body(category.getName());
    }

    @PutMapping("/disable")
    public ResponseEntity<String> disableCategory(@RequestBody Category category){
        category.setDisable(true);
        categoryService.updateCategory(category);
        return ResponseEntity.ok().body(category.getName());
    }
}
