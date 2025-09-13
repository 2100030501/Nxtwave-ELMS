package com.example.leave.dto;

import com.example.leave.model.Employee;
import com.example.leave.model.Manager;

public class EmployeeResponseDTO {
    private Integer eid;
    private String ename;
    private Boolean ereq;
    private Integer managerId;
    private String managerName;

    
    public static EmployeeResponseDTO fromEntity(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEid(employee.getEid());
        dto.setEname(employee.getEname());
        dto.setEreq(employee.getEreq());

        Manager m = employee.getManager();
        if (m != null) {
            dto.setManagerId(m.getMid());
            dto.setManagerName(m.getMname());
        }
        return dto;
    }

    public Integer getEid() { return eid; }
    public void setEid(Integer eid) { this.eid = eid; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public Boolean getEreq() { return ereq; }
    public void setEreq(Boolean ereq) { this.ereq = ereq; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}
