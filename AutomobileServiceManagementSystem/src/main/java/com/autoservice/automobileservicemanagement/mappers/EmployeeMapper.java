package com.autoservice.automobileservicemanagement.mappers;

import com.autoservice.automobileservicemanagement.dto.EmployeeDto;
import com.autoservice.automobileservicemanagement.model.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDto convertToDto(Employee employee){
        return EmployeeDto.builder()
                .username(employee.getUsername())
                .fullName(employee.getFullName())
                .userType(employee.getUserType())
                .build();
    }

    public static Employee convertToUser(EmployeeDto employeeDto){
        return Employee.builder()
                .fullName(employeeDto.getFullName())
                .username(employeeDto.getUsername())
                .userType(employeeDto.getUserType())
                .build();
    }

}
