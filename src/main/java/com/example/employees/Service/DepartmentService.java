package com.example.employees.Service;

import com.example.employees.DTOs.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long departmentId);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartment);

    void deleteDepartment(Long departmentId);
}
