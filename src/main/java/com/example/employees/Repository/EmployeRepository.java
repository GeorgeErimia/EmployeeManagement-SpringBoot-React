package com.example.employees.Repository;

import com.example.employees.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee, Long> {

}
