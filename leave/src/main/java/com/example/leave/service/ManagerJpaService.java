package com.example.leave.service;

import com.example.leave.dto.ManagerRequestDTO;
import com.example.leave.dto.ManagerResponseDTO;
import com.example.leave.model.Admin;
import com.example.leave.model.Manager;
import com.example.leave.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerJpaService implements ManagerRepository{
    @Autowired
    private  ManagerJpaRepository managerRepo;
    @Autowired
    private  AdminJpaRepository adminRepo;

    public ManagerJpaService(ManagerJpaRepository managerRepo, AdminJpaRepository adminRepo) {
        this.managerRepo = managerRepo;
        this.adminRepo = adminRepo;
    }

    public ManagerResponseDTO addManager(ManagerRequestDTO dto) {
        Admin admin = adminRepo.findById(dto.getAdminId()).orElseThrow();
        Manager manager = new Manager(dto.getMname(), dto.getMstatus(), admin);
        return ManagerResponseDTO.fromEntity(managerRepo.save(manager));
    }

    public List<ManagerResponseDTO> getAllManagers() {
        return managerRepo.findAll().stream()
                .map(ManagerResponseDTO::fromEntity)
                .toList();
    }

    public ManagerResponseDTO getManagerById(int id) {
        return managerRepo.findById(id)
                .map(ManagerResponseDTO::fromEntity)
                .orElseThrow();
    }
}
