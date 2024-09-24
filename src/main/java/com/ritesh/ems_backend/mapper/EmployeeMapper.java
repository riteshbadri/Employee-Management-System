package com.ritesh.ems_backend.mapper;

import com.ritesh.ems_backend.dto.EmployeeDto;
import com.ritesh.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto empDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDept()
        );
        return empDto;
    }

    public static Employee mapToEmployee(EmployeeDto empDto) {
        Employee employee = new Employee(
                empDto.id(),
                empDto.firstName(),
                empDto.lastName(),
                empDto.email(),
                empDto.dept()
        );
        return employee;
    }

}
