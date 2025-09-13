package com.example.leave.repository;

import com.example.leave.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatusJpaRepository extends JpaRepository<Status, Integer> {
    List<Status> findByEmployeeEid(int eid);
    List<Status> findByManagerMid(int mid);
    List<Status> findByAdminAid(int aid);
}
