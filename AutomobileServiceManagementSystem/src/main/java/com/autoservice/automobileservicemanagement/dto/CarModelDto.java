package com.autoservice.automobileservicemanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarModelDto {
    private Long id;

    private String brand;

    private String model;

    private String year;

    private String engine;
}
