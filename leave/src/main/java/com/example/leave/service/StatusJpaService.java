package com.example.leave.service;

//import com.example.leave.dto.StatusRequestDTO;
import com.example.leave.dto.StatusResponseDTO;
import com.example.leave.model.*;


import com.example.leave.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatusJpaService implements StatusRepository{
    @Autowired
    private  StatusJpaRepository statusRepo;
    @Autowired
    private  EmployeeJpaRepository employeeRepo;


    public StatusResponseDTO requestLeave(int empId, String text) {
        Employee emp = employeeRepo.findById(empId).orElseThrow();

        Status status = new Status();
        status.setEmployee(emp);
        status.setManager(emp.getManager());
        status.setAdmin(emp.getManager().getAdmin());
        status.setMstatus("PENDING");
        status.setEreqText(text.replaceAll("[\"\\r\\n]", "").trim());
        status.setRequestedDate(LocalDate.now());

        return StatusResponseDTO.fromEntity(statusRepo.save(status));
    }
    public StatusResponseDTO approveLeave(int empId, String statusRequestDTO) {
        // Find the original leave request by employee ID
        Status status = statusRepo.findById(empId).get();

        if (status == null) {
            throw new RuntimeException("Leave request not found for employee ID " + empId);
        }

        // Update the status of the leave request
        status.setMstatus(statusRequestDTO.replaceAll("[\"\\r\\n]", "").trim());  // Update the status (APPROVED/REJECTED)
        //status.setApprovalText(statusRequestDTO.getApprovalText()); // Save the manager's approval/rejection text

        // Save the updated status to the database
        Status updatedStatus = statusRepo.save(status);

        // Return the updated status in a DTO format
        return StatusResponseDTO.fromEntity(updatedStatus);
    }
    public List<StatusResponseDTO> getStatusesByEmployee(int eid) {
        return statusRepo.findByEmployeeEid(eid)
                .stream()
                .map(StatusResponseDTO::fromEntity)
                .toList();
    }

    public List<StatusResponseDTO> getStatusesByManager(int mid) {
        return statusRepo.findByManagerMid(mid)
                .stream()
                .map(StatusResponseDTO::fromEntity)
                .toList();
    }

    public List<StatusResponseDTO> getStatusesByAdmin(int aid) {
        return statusRepo.findByAdminAid(aid)
                .stream()
                .map(StatusResponseDTO::fromEntity)
                .toList();
    }
}
