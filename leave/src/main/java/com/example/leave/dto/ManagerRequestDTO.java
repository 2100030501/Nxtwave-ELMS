package com.example.leave.dto;

public class ManagerRequestDTO {
    private String mname;
    private String mstatus;
    private Integer adminId;

    public String getMname() { return mname; }
    public void setMname(String mname) { this.mname = mname; }

    public String getMstatus() { return mstatus; }
    public void setMstatus(String mstatus) { this.mstatus = mstatus; }

    public Integer getAdminId() { return adminId; }
    public void setAdminId(Integer adminId) { this.adminId = adminId; }
}
