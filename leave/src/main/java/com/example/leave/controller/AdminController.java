package com.example.leave.controller;

import com.example.leave.dto.*;
import com.example.leave.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/admins")
@RestController
public class AdminController {
    private final AdminJpaService adminService;

    public AdminController(AdminJpaService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admins")
    public AdminResponseDTO addAdmin(@RequestBody AdminRequestDTO dto) {
        return adminService.addAdmin(dto);
    }

    @GetMapping("/admins")
    public List<AdminResponseDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("admins/{id}")
    public AdminResponseDTO getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }
}
