package com.autoservice.automobileservicemanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderPartDto {
    private Long id;
    private Long orderId;
    private Long partId;
    private Integer quantity;
}
