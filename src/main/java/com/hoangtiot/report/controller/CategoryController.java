package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    public ResponseEntity<Category> findById(@PathVariable @Min(1) @NotNull int id){
        return ResponseEntity.ok().body(categoryService.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@Valid @RequestBody Category category){
        String rs = "Add new category failed";
        if(categoryService.addCategory(category))
            rs="Add "+category.getName()+" successfully";
        return ResponseEntity.ok().body(rs);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category){
        String rs = "Update failed";
        if (categoryService.updateCategory(category))
            rs = "Update "+category.getName()+" successfully";
        return ResponseEntity.ok().body(rs);
    }

    @PatchMapping("/disable")
    public ResponseEntity<String> disableCategory(@Valid @RequestBody Category category){
        String rs = "Update failed";
        category.setDisable(true);
        if (categoryService.updateCategory(category))
            rs = "Update "+category.getName()+" successfully";
        return ResponseEntity.ok().body(rs);
    }
}
