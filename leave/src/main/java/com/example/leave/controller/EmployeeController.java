package com.example.leave.controller;

import com.example.leave.dto.*;
import com.example.leave.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/employees")
@RestController
public class EmployeeController {
    private final EmployeeJpaService employeeService;

    public EmployeeController(EmployeeJpaService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO dto) {
        return employeeService.addEmployee(dto);
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}
