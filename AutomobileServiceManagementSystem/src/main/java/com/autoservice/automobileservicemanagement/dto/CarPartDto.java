package com.autoservice.automobileservicemanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarPartDto {
    private Long id;
    private String name;
    private String partNumber;
    private Integer price;
    private Integer quantity;
    private Long carModelId;
}
