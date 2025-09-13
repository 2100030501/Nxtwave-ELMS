package com.example.leave.dto;

public class EmployeeRequestDTO {
    private String ename;
    private Boolean ereq;
    private Integer managerId; 

    
    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public Boolean getEreq() { return ereq; }
    public void setEreq(Boolean ereq) { this.ereq = ereq; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }
}
