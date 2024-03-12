package com.example.employees.Helper;

import com.example.employees.DTOs.EmployeeDTO;
import com.example.employees.Model.Employee;

// CLASS THAT HELPS MAP EMPLOYEE ENTITIES TO EMPLOYEE DTOS AND VICE VERSA
public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
