package com.ritesh.ems_backend.service.Impl;

import com.ritesh.ems_backend.dto.EmployeeDto;
import com.ritesh.ems_backend.entity.Employee;
import com.ritesh.ems_backend.exception.ResourceNotFoundException;
import com.ritesh.ems_backend.mapper.EmployeeMapper;
import com.ritesh.ems_backend.repository.EmployeeRepository;
import com.ritesh.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("No employee with the ID: "+ employeeId ));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No employee with ID: "+ id));
        employee.setFirstName(updatedEmployee.firstName());
        employee.setLastName(updatedEmployee.lastName());
        employee.setEmail(updatedEmployee.email());
        employee.setDept(updatedEmployee.dept());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Deleted employee of ID: "+id;
    }
}
