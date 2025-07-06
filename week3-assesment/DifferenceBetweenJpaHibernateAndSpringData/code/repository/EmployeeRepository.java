package com.example.jpa_hybernate_diff.repository;

import com.example.jpa_hybernate_diff.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
