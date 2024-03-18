package com.example.employees.Helper;

import com.example.employees.DTOs.DepartmentDTO;
import com.example.employees.Model.Department;

public class DepartmentMapper {

    // Create a static method to convert jpa entity into department DTO
    public static DepartmentDTO mapToDepartmentDTO(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription());
    }

    // Create a static method to convert department DTO to jpa entity
    public static Department mapToDepartment(DepartmentDTO departmentDTO) {
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription());
    }
}
