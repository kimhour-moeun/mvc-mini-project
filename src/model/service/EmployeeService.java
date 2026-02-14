package model.service;

import dto.EmployeeCreateDto;
import dto.EmployeeDeleteDto;
import dto.EmployeeResponse;
import dto.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeCreateDto createDto);
    Boolean deleteById(Long id);
    List<EmployeeResponse> getAllEmployee(int offset, int limit);
    EmployeeResponse updateById(Long id, EmployeeUpdateDto employee);
    EmployeeResponse getById(Long id);

}
