package com.example.spring_transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_transaction.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
