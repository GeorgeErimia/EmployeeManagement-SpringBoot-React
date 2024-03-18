package com.example.employees.Controller;

import com.example.employees.DTOs.DepartmentDTO;
import com.example.employees.Helper.DepartmentMapper;
import com.example.employees.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    // Create a REST API POST method to create or add Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Create a REST API GET method to return a department by ID
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") final Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    // Create a REST API GET method to return all departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Create a REST API PUT method to update a department
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") final Long departmentId, @RequestBody DepartmentDTO updatedDepartment) {
        DepartmentDTO departmentDTO = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDTO);
    }

    // Create a REST API DELETE method to delete a department
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") final Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!");
    }
}
