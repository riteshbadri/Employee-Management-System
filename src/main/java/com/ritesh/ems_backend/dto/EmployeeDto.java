package com.ritesh.ems_backend.dto;

public record EmployeeDto(Long id,
                          String firstName,
                          String lastName,
                          String email,
                          String dept) {
}
