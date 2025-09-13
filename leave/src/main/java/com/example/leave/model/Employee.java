package com.example.leave.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Integer eid;

    @Column(name = "ename", nullable = false)
    private String ename;

    @Column(name = "ereq")
    private Boolean ereq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid")
    private Manager manager;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses;

    public Employee() {}

    public Employee(String ename, Boolean ereq, Manager manager) {
        this.ename = ename;
        this.ereq = ereq;
        this.manager = manager;
    }

    public Integer getEid() { return eid; }
    public void setEid(Integer eid) { this.eid = eid; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public Boolean getEreq() { return ereq; }
    public void setEreq(Boolean ereq) { this.ereq = ereq; }

    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    public List<Status> getStatuses() { return statuses; }
    public void setStatuses(List<Status> statuses) { this.statuses = statuses; }
}
