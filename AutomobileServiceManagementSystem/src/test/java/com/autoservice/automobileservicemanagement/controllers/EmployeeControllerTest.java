package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.EmployeeDto;
import com.autoservice.automobileservicemanagement.mocks.EmployeeEntitiesMocks;
import com.autoservice.automobileservicemanagement.model.entities.Employee;
import com.autoservice.automobileservicemanagement.mappers.EmployeeMapper;
import com.autoservice.automobileservicemanagement.services.EmployeeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @Test
    public void checkGetUserHappyUsecase() {
        when(employeeService.getEmployeeByUsername("andrei.ion")).thenReturn(EmployeeEntitiesMocks.getEmployeesMock().stream()
                .filter(u -> u.getUsername().equals("andrei.ion"))
                .map(EmployeeMapper::convertToDto).findFirst().orElse(null));

        ResponseEntity<EmployeeDto> result = employeeController.getEmployee("andrei.ion");
        assert result.getStatusCode().is2xxSuccessful();
        assert Objects.requireNonNull(result.getBody()).getUsername().equals("andrei.ion");
    }

    @Test
    public void checkGetUserUnhappyUsecase() {
        when(employeeService.getEmployeeByUsername("andrei.ion")).thenReturn(null);

        ResponseEntity<EmployeeDto> result = employeeController.getEmployee("andrei.ion");
        assert result.getStatusCode().is2xxSuccessful();
        assertNull(result.getBody());
    }

    @Test
    public void checkAddUserHappyUsecase() {
        Employee u = EmployeeEntitiesMocks.getEmployeesMock().get(1);
        u.setId(null);
        when(employeeService.addUser(EmployeeMapper.convertToDto(u)))
                .thenReturn(EmployeeMapper.convertToDto(u));

        ResponseEntity<EmployeeDto> returned = employeeController.addEmployee(EmployeeMapper.convertToDto(u));
        assert returned.getBody() != null;
        Employee returnedEmployee = EmployeeMapper.convertToUser(returned.getBody());
        assertEquals(u, returnedEmployee);
    }

    @Test
    public void checkAddUserUnhappyUsecase() {
        Employee u = EmployeeEntitiesMocks.getEmployeesMock().get(1);
        u.setId(null);
        when(employeeService.addUser(EmployeeMapper.convertToDto(u)))
                .thenThrow(new RuntimeException("Employee already exists"));

        assertThrows(RuntimeException.class, () -> {
            ResponseEntity<EmployeeDto> resp = employeeController.addEmployee(EmployeeMapper.convertToDto(u));
        });
    }

    @Test
    public void checkGetUserByUsernameAndTypeHappyUsecase() {
        Employee u = EmployeeEntitiesMocks.getEmployeesMock().get(1);
        when(employeeService.getUserByUsernameAndType("andrei.ion", "user"))
                .thenReturn(Collections.singletonList(EmployeeMapper.convertToDto(u)));

        ResponseEntity<List<EmployeeDto>> result = employeeController.getByType("andrei.ion", "user");
        assertNotNull(result.getBody());
        assertEquals("andrei.ion", result.getBody().get(0).getUsername());
    }

    @Test
    public void checkGetUserByUsernameAndTypeUnhappyUsecase() {
        List<EmployeeDto> result = employeeService.getUserByUsernameAndType("andrei.ion", "admin");
        assert (result.isEmpty());

    }

}
