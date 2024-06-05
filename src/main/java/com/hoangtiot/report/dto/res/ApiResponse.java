package com.hoangtiot.report.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Builder
@Value
@Getter
@Setter
public class ApiResponse<T>{
    @Builder.Default
    private int code = 200;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
