package com.example.leave.repository;

import com.example.leave.dto.AdminRequestDTO;
import com.example.leave.dto.AdminResponseDTO;
import java.util.*;

public interface AdminRepository {
    List<AdminResponseDTO> getAllAdmins();
    AdminResponseDTO getAdminById(int id);
    AdminResponseDTO addAdmin(AdminRequestDTO dto);
    // Admin update(int id, Admin a);
    // void delete(int id);
}
