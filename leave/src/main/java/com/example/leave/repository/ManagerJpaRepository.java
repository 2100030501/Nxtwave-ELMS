package com.example.leave.repository;

import com.example.leave.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerJpaRepository extends JpaRepository<Manager, Integer> { }
