package com.example.leave.dto;

public class StatusRequestDTO {

    private String status;         // "APPROVED" or "REJECTED"
    //private String approvalText;   // Optional text from manager for approval or rejection

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // public String getApprovalText() {
    //     return approvalText;
    // }

    // public void setApprovalText(String approvalText) {
    //     this.approvalText = approvalText;
    // }

    // Constructor
    public StatusRequestDTO(String status, String approvalText) {
        this.status = status;
        //this.approvalText = approvalText;
    }

    public StatusRequestDTO() {
        // Default constructor
    }
}
