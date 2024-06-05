package com.hoangtiot.report.dto.res;

import com.hoangtiot.report.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class CategoryResDto {
//    @Min(1)
//    @NotNull(message = "Id can not be null")
    private int id;
//    @NotNull(message = "Category Name can not be null")
    private String name;
    private boolean isDisable;

    public void fromCategory(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.isDisable = category.isDisable();
    }
}
