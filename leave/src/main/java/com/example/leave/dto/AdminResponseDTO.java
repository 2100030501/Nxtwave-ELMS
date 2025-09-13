package com.example.leave.dto;

import com.example.leave.model.Admin;

public class AdminResponseDTO {
    private Integer aid;
    private String aname;

    public static AdminResponseDTO fromEntity(Admin admin) {
        AdminResponseDTO dto = new AdminResponseDTO();
        dto.setAid(admin.getAid());
        dto.setAname(admin.getAname());
        return dto;
    }

    public Integer getAid() { return aid; }
    public void setAid(Integer aid) { this.aid = aid; }
    public String getAname() { return aname; }
    public void setAname(String aname) { this.aname = aname; }
}
