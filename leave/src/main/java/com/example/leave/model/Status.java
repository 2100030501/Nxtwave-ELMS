package com.example.leave.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "statuses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Integer sid;

    // Status belongs to one employee
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eid", nullable = false)
    @JsonIgnoreProperties("managers")
    private Employee employee;

    // Status belongs to one manager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid", nullable = false)
    private Manager manager;

    // Status optionally belongs to an admin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aid")
    private Admin admin;

    @Column(name = "mstatus")
    private String mstatus;

    @Column(name = "ereq_text")
    private String ereqText;

    @Column(name = "requested_date")
    private LocalDate requestedDate;

    public Status() {}

    public Status(Employee employee, Manager manager, Admin admin,
                  String mstatus, String ereqText, LocalDate requestedDate) {
        this.employee = employee;
        this.manager = manager;
        this.admin = admin;
        this.mstatus = mstatus;
        this.ereqText = ereqText;
        this.requestedDate = requestedDate;
    }

    public Integer getSid() { return sid; }
    public void setSid(Integer sid) { this.sid = sid; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public String getMstatus() { return mstatus; }
    public void setMstatus(String mstatus) { this.mstatus = mstatus; }

    public String getEreqText() { return ereqText; }
    public void setEreqText(String ereqText) { this.ereqText = ereqText; }

    public LocalDate getRequestedDate() { return requestedDate; }
    public void setRequestedDate(LocalDate requestedDate) { this.requestedDate = requestedDate; }
}
