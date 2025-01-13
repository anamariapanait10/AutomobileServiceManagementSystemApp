package com.autoservice.automobileservicemanagement.dto;

import com.autoservice.automobileservicemanagement.validator.OnlyLetters;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private String username;

    @OnlyLetters()
    private String fullName;
    private String userType;

}
