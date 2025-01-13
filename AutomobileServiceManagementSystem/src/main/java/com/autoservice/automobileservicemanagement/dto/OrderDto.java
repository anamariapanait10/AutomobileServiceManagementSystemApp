package com.autoservice.automobileservicemanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long id;
    private Long clientId;
    private Long employeeId;
    private Long carModelId;
    private LocalDate orderDate;
    private String status;
    private List<OrderPartDto> orderParts;
}
