package com.example.leave.model;

import jakarta.persistence.*;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "managers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Integer mid;

    @Column(name = "mname", nullable = false)
    private String mname;

    @Column(name = "mstatus")
    private String mstatus;

    // Many managers belong to one admin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aid")
    //@JsonIgnoreProperties("statuses")
    @JsonIgnoreProperties("managers")
    private Admin admin;

    // One manager -> many employees
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    // One manager -> many statuses
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses;

    public Manager() {}

    public Manager(String mname, String mstatus, Admin admin) {
        this.mname = mname;
        this.mstatus = mstatus;
        this.admin = admin;
    }

    public Integer getMid() { return mid; }
    public void setMid(Integer mid) { this.mid = mid; }

    public String getMname() { return mname; }
    public void setMname(String mname) { this.mname = mname; }

    public String getMstatus() { return mstatus; }
    public void setMstatus(String mstatus) { this.mstatus = mstatus; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public List<Status> getStatuses() { return statuses; }
    public void setStatuses(List<Status> statuses) { this.statuses = statuses; }
}
