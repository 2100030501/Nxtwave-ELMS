package com.example.leave.repository;

import com.example.leave.dto.ManagerRequestDTO;
import com.example.leave.dto.ManagerResponseDTO;
import java.util.List;

public interface ManagerRepository {
    ManagerResponseDTO addManager(ManagerRequestDTO dto);
    List<ManagerResponseDTO> getAllManagers();
    ManagerResponseDTO getManagerById(int id);
}
