package com.example.leave.controller;

//import com.example.leave.dto.StatusRequestDTO;
import com.example.leave.dto.StatusResponseDTO;
import com.example.leave.service.StatusJpaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/statuses")
@RestController

public class StatusController {

    private final StatusJpaService statusService;

    public StatusController(StatusJpaService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/statuses/{empId}/request")
    public StatusResponseDTO requestLeave(@PathVariable int empId,
                                          @RequestBody String text) {
        return statusService.requestLeave(empId, text);
    }
    @PutMapping("statuses/{empId}/approve")
    public StatusResponseDTO approveLeave(@PathVariable int empId,
                                          @RequestBody String statusRequestDTO) {
        return statusService.approveLeave(empId, statusRequestDTO);
    }
    @GetMapping("/statuses/employee/{eid}")
    public List<StatusResponseDTO> getStatusesByEmployee(@PathVariable int eid) {
        return statusService.getStatusesByEmployee(eid);
    }

    @GetMapping("/statuses/manager/{mid}")
    public List<StatusResponseDTO> getStatusesByManager(@PathVariable int mid) {
        return statusService.getStatusesByManager(mid);
    }

    @GetMapping("/statuses/admin/{aid}")
    public List<StatusResponseDTO> getStatusesByAdmin(@PathVariable int aid) {
        return statusService.getStatusesByAdmin(aid);
    }

}
