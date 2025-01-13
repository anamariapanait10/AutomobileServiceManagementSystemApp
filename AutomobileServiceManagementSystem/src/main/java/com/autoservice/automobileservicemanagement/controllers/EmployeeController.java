package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.EmployeeDto;
import com.autoservice.automobileservicemanagement.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Management", description = "Manage employees and their details")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(summary = "Get an employee by username", description = "Retrieve details of an employee by their username")
    @GetMapping("/{username}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String username) {
        return ResponseEntity.ok(employeeService.getEmployeeByUsername(username));
    }

    @Operation(summary = "Add a new employee", description = "Add a new employee to the system")
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.addUser(employeeDto));
    }

    @Operation(summary = "Get employees by type", description = "Retrieve employees filtered by username and type")
    @GetMapping("/type")
    public ResponseEntity<List<EmployeeDto>> getByType(@RequestParam("username") String username, @RequestParam("type") String type) {
        return ResponseEntity.ok(employeeService.getUserByUsernameAndType(username, type));
    }
}
