package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.EmployeeDto;
import com.autoservice.automobileservicemanagement.model.entities.Employee;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.EmployeeMapper;
import com.autoservice.automobileservicemanagement.mocks.EmployeeEntitiesMocks;

import com.autoservice.automobileservicemanagement.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void checkGetUserByUsernameHappyUsecase() {
        when(employeeRepository.findUserByUsername("andrei.ion")).thenReturn(EmployeeEntitiesMocks.getEmployeesMock().get(1));

        EmployeeDto result = employeeService.getEmployeeByUsername("andrei.ion");
        assertEquals("andrei.ion345", result.getUsername());
    }

    @Test
    public void checkGetUserByUsernameUnhappyUsecase() {
        assertThrows(DataNotFoundException.class, () -> {
            EmployeeDto result = employeeService.getEmployeeByUsername("andrei.ion");
        });
    }

    @Test
    public void checkAddUserHappyUsecase() {
        when(employeeRepository.findUserByUsername("andrei.ion")).thenReturn(null);
        Employee u = EmployeeEntitiesMocks.getEmployeesMock().get(1);
        u.setId(null);
        when(employeeRepository.save(u)).thenReturn(u);

        EmployeeDto returned = employeeService.addUser(EmployeeMapper.convertToDto(u));
        Employee returnedEmployee = EmployeeMapper.convertToUser(returned);
        assertEquals(u, returnedEmployee);
    }

    @Test
    public void checkAddUserUnappyUsecase() {
        when(employeeRepository.findUserByUsername("andrei.ion")).thenReturn(EmployeeEntitiesMocks.getEmployeesMock().get(1));
        Employee u = EmployeeEntitiesMocks.getEmployeesMock().get(1);
        u.setId(null);

        assertThrows(RuntimeException.class, () -> {
            EmployeeDto returned = employeeService.addUser(EmployeeMapper.convertToDto(u));
            EmployeeDto returned2 = employeeService.addUser(EmployeeMapper.convertToDto(u));
        });
    }

    @Test
    public void checkGetUserByUsernameAndTypeHappyUsecase() {
        when(employeeRepository.findUserByCustomQuery("andrei.ion", "user")).thenReturn(Arrays.asList(EmployeeEntitiesMocks.getEmployeesMock().get(1)));

        List<EmployeeDto> result = employeeService.getUserByUsernameAndType("andrei.ion", "user");
        assertEquals("andrei.ion", result.get(0).getUsername());
    }

    @Test
    public void checkGetUserByUsernameAndTypeUnhappyUsecase() {
        List<EmployeeDto> result = employeeService.getUserByUsernameAndType("andrei.ion", "admin");
        assert(result.isEmpty());

    }

}
