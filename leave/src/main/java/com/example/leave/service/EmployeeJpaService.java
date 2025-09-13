package com.example.leave.service;

import com.example.leave.dto.*;
import com.example.leave.model.*;
import com.example.leave.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeJpaService implements EmployeeRepository{
    @Autowired
    private  EmployeeJpaRepository employeeRepo;
    @Autowired
    private  ManagerJpaRepository managerRepo;

    

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto) {
        Manager manager = managerRepo.findById(dto.getManagerId()).orElseThrow();
        Employee emp = new Employee(dto.getEname(), dto.getEreq(), manager);
        return EmployeeResponseDTO.fromEntity(employeeRepo.save(emp));
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(EmployeeResponseDTO::fromEntity)
                .toList();
    }

    public EmployeeResponseDTO getEmployeeById(int id) {
        return employeeRepo.findById(id)
                .map(EmployeeResponseDTO::fromEntity)
                .orElseThrow();
    }
}
