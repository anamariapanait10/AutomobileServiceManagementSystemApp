package com.autoservice.automobileservicemanagement.mocks;

import com.autoservice.automobileservicemanagement.model.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeEntitiesMocks {

    public static List<Employee> getEmployeesMock() {
        Employee employee = Employee.builder().fullName("Maria Cristea").userType("admin").username("maria.cristea").id(13L).build();
        Employee employee2 = Employee.builder().fullName("Andrei Ion").userType("user").username("andrei.ion").id(15L).build();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);
        return employeeList;//.stream().map(UserMapper::convertToDto).toList();
    }

}
