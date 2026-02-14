package mapper;

import dto.EmployeeCreateDto;
import dto.EmployeeResponse;

import model.entities.Employee;


public class EmployeeMapper {
    public Employee fromEmployeeCreateDto(EmployeeCreateDto createDto){
        return new Employee(
                createDto.fullName(),
                createDto.salary(),
                createDto.hireDate()
        );

    }
    public EmployeeResponse toEmployeeResponse(Employee employee){
        return  EmployeeResponse.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .salary(employee.getSalary())
                .hireDate(employee.getHireDate())
                .build();
    }
}
