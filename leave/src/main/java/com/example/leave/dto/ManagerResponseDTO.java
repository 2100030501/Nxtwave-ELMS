package com.example.leave.dto;

import com.example.leave.model.Manager;

public class ManagerResponseDTO {
    private Integer mid;
    private String mname;
    private String mstatus;
    private Integer adminId;
    private String adminName;

    public static ManagerResponseDTO fromEntity(Manager manager) {
        ManagerResponseDTO dto = new ManagerResponseDTO();
        dto.setMid(manager.getMid());
        dto.setMname(manager.getMname());
        dto.setMstatus(manager.getMstatus());

        if (manager.getAdmin() != null) {
            dto.setAdminId(manager.getAdmin().getAid());
            dto.setAdminName(manager.getAdmin().getAname());
        }
        return dto;
    }

    public Integer getMid() { return mid; }
    public void setMid(Integer mid) { this.mid = mid; }

    public String getMname() { return mname; }
    public void setMname(String mname) { this.mname = mname; }

    public String getMstatus() { return mstatus; }
    public void setMstatus(String mstatus) { this.mstatus = mstatus; }

    public Integer getAdminId() { return adminId; }
    public void setAdminId(Integer adminId) { this.adminId = adminId; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
}
