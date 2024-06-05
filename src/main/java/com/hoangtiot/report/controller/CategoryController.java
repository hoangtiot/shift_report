package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.res.ApiResponse;
import com.hoangtiot.report.dto.res.CategoryResDto;
import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ApiResponse<List<CategoryResDto>> findAll(){
        List<CategoryResDto> listDto = new ArrayList<>();
        for (Category category : categoryService.findAllAvailable()){
            CategoryResDto dto = new CategoryResDto();
            dto.fromCategory(category);
            listDto.add(dto);
        }
        return ApiResponse.<List<CategoryResDto>>builder().data(listDto).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResDto> findById(@PathVariable @Min(1) @NotNull int id){
        CategoryResDto dto = new CategoryResDto();
        dto.fromCategory(categoryService.findById(id).orElse(null));
        return ApiResponse.<CategoryResDto>builder().data(dto).build();
    }

    @PostMapping("/add/{categoryName}")
    public ApiResponse<String> addCategory(@PathVariable String categoryName){
        String rs = "Add new category failed";
        if(categoryService.addCategory(categoryName))
            rs="Add "+categoryName+" successfully";
        return ApiResponse.<String>builder().data(rs).build();
    }

    @PutMapping("/update/{id}/{newName}")
    public ApiResponse<String> updateCategory(@PathVariable String newName, @PathVariable int id){
        String rs = "Update failed";
        if (categoryService.updateCategory(newName, id))
            rs = "Update "+id+" successfully";
        return ApiResponse.<String>builder().data(rs).build();
    }

    @PatchMapping("/updateDisable/{id}")
    public ApiResponse<String> disableCategory(@PathVariable int id){
        String rs = "Update failed";
        if (categoryService.updateDisableCategory(id))
            rs = "Update disable status"+ id +" successfully";
        return ApiResponse.<String>builder().data(rs).build();
    }
}
