package com.autoservice.automobileservicemanagement.dto;

import com.autoservice.automobileservicemanagement.validator.OnlyLetters;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private Long id;

    @OnlyLetters()
    private String fullName;
    private String address;
    private String phone;
}
