package com.example.leave.repository;

import com.example.leave.dto.EmployeeRequestDTO;
import com.example.leave.dto.EmployeeResponseDTO;
import java.util.List;

public interface EmployeeRepository {
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO getEmployeeById(int id);
}
