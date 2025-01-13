package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.EmployeeDto;
import com.autoservice.automobileservicemanagement.model.entities.Employee;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.EmployeeMapper;
import com.autoservice.automobileservicemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.autoservice.automobileservicemanagement.mappers.EmployeeMapper.convertToDto;
import static com.autoservice.automobileservicemanagement.mappers.EmployeeMapper.convertToUser;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto getEmployeeByUsername(String username) {
        Employee employee = employeeRepository.findUserByUsername(username);
        if (employee == null) {
            throw new DataNotFoundException("Employee not found");
        }
        return EmployeeMapper.convertToDto(employee);
    }

    public EmployeeDto addUser(EmployeeDto employeeDto){
        Employee employee = employeeRepository.findUserByUsername(employeeDto.getUsername());
        if (employee != null){
            throw new RuntimeException("Employee already exists");
        }
        return convertToDto(employeeRepository.save(convertToUser(employeeDto)));
    }

    public List<EmployeeDto> getUserByUsernameAndType(String username, String type){
        return employeeRepository.findUserByCustomQuery(username, type)
                .stream()
                .map(EmployeeMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
