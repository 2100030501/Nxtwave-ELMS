package com.example.leave.controller;

import com.example.leave.dto.*;
import com.example.leave.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/managers")
@RestController

public class ManagerController {
    private final ManagerJpaService managerService;

    public ManagerController(ManagerJpaService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/managers")
    public ManagerResponseDTO addManager(@RequestBody ManagerRequestDTO dto) {
        return managerService.addManager(dto);
    }

    @GetMapping("/managers")
    public List<ManagerResponseDTO> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/managers/{id}")
    public ManagerResponseDTO getManagerById(@PathVariable int id) {
        return managerService.getManagerById(id);
    }
}
