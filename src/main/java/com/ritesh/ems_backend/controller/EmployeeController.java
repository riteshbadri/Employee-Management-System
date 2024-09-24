package com.ritesh.ems_backend.controller;

import com.ritesh.ems_backend.dto.EmployeeDto;
import com.ritesh.ems_backend.entity.Employee;
import com.ritesh.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // rest api for create employee+
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // employee find by id rest api
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // get all employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeesDto = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeesDto);
    }

    //update employee
    @PutMapping("/{id}/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String deletedDisplay = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deletedDisplay);
    }

}
