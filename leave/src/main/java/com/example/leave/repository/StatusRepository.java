package com.example.leave.repository;

//import com.example.leave.dto.StatusRequestDTO;
import com.example.leave.dto.StatusResponseDTO;
import java.util.List;


public interface StatusRepository  {
    StatusResponseDTO requestLeave(int empId, String text);
    List<StatusResponseDTO> getStatusesByEmployee(int eid);
    List<StatusResponseDTO> getStatusesByManager(int mid);
    List<StatusResponseDTO> getStatusesByAdmin(int aid);
    StatusResponseDTO approveLeave(int empId, String statusRequestDTO);
}
