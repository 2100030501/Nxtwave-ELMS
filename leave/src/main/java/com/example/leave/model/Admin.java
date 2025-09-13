package com.example.leave.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "admins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer aid;

    @Column(name = "aname", nullable = false)
    private String aname;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("statuses")
    private List<Manager> managers;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("admins")
    private List<Status> statuses;

    public Admin() {}

    public Admin(String aname) {
        this.aname = aname;
    }

    public Integer getAid() { return aid; }
    public void setAid(Integer aid) { this.aid = aid; }

    public String getAname() { return aname; }
    public void setAname(String aname) { this.aname = aname; }

    public List<Manager> getManagers() { return managers; }
    public void setManagers(List<Manager> managers) { this.managers = managers; }

    public List<Status> getStatuses() { return statuses; }
    public void setStatuses(List<Status> statuses) { this.statuses = statuses; }
}
