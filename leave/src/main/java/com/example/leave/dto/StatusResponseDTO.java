package com.example.leave.dto;

import com.example.leave.model.Status;
import java.time.LocalDate;

public class StatusResponseDTO {
    private Integer sid;
    private String mstatus;
    private String ereqText;
    private LocalDate requestedDate;

    private Integer empId;
    private String empName;

    private Integer managerId;
    private String managerName;

    private Integer adminId;
    private String adminName;


    public Integer getSid() { return sid; }
    public void setSid(Integer sid) { this.sid = sid; }

    public String getMstatus() { return mstatus; }
    public void setMstatus(String mstatus) { this.mstatus = mstatus; }

    public String getEreqText() { return ereqText; }
    public void setEreqText(String ereqText) { this.ereqText = ereqText; }

    public LocalDate getRequestedDate() { return requestedDate; }
    public void setRequestedDate(LocalDate requestedDate) { this.requestedDate = requestedDate; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public Integer getAdminId() { return adminId; }
    public void setAdminId(Integer adminId) { this.adminId = adminId; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public static StatusResponseDTO fromEntity(Status status) {
        StatusResponseDTO dto = new StatusResponseDTO();
        dto.setSid(status.getSid());
        dto.setMstatus(status.getMstatus());
        dto.setEreqText(status.getEreqText());
        dto.setRequestedDate(status.getRequestedDate());

        if (status.getEmployee() != null) {
            dto.setEmpId(status.getEmployee().getEid());
            dto.setEmpName(status.getEmployee().getEname());
        }

        if (status.getManager() != null) {
            dto.setManagerId(status.getManager().getMid());
            dto.setManagerName(status.getManager().getMname());
        }

        if (status.getAdmin() != null) {
            dto.setAdminId(status.getAdmin().getAid());
            dto.setAdminName(status.getAdmin().getAname());
        }

        return dto;
    }
}
