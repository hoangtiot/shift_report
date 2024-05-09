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

    @PostMapping("/add/{categoryName}")
    public ResponseEntity<String> addCategory(@PathVariable String categoryName){
        String rs = "Add new category failed";
        if(categoryService.addCategory(categoryName))
            rs="Add "+categoryName+" successfully";
        return ResponseEntity.ok().body(rs);
    }

    @PutMapping("/update/{id}/{newName}")
    public ResponseEntity<String> updateCategory(@PathVariable String newName, @PathVariable int id){
        String rs = "Update failed";
        if (categoryService.updateCategory(newName, id))
            rs = "Update "+id+" successfully";
        return ResponseEntity.ok().body(rs);
    }

    @PatchMapping("/updateDisable/{id}")
    public ResponseEntity<String> disableCategory(@PathVariable int id){
        String rs = "Update failed";
        if (categoryService.updateDisableCategory(id))
            rs = "Update disable status"+ id +" successfully";
        return ResponseEntity.ok().body(rs);
    }
}
