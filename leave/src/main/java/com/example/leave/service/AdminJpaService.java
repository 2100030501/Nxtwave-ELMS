package com.example.leave.service;

import com.example.leave.dto.*;
import com.example.leave.model.*;
import com.example.leave.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminJpaService implements AdminRepository{
    @Autowired
    private  AdminJpaRepository adminRepo;

    // private AdminJpaRepository adminRepo;

    // public AdminJpaService(AdminJpaRepository adminRepo) {
    //     this.adminRepo = adminRepo;
    // }

    public AdminResponseDTO addAdmin(AdminRequestDTO dto) {
        Admin admin = new Admin(dto.getAname());
        return AdminResponseDTO.fromEntity(adminRepo.save(admin));
    }

    public List<AdminResponseDTO> getAllAdmins() {
        return adminRepo.findAll().stream()
                .map(AdminResponseDTO::fromEntity)
                .toList();
    }

    public AdminResponseDTO getAdminById(int id) {
        return adminRepo.findById(id)
                .map(AdminResponseDTO::fromEntity)
                .orElseThrow();
    }
}
