package model.service;

import dto.EmployeeCreateDto;
import dto.EmployeeResponse;
import dto.EmployeeUpdateDto;
import exception.EmployeeException;
import mapper.EmployeeMapper;
import model.dao.EmployeeDao;
import model.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeDao dao;
    private final EmployeeMapper mapper;
    public EmployeeServiceImpl (EmployeeDao dao, EmployeeMapper mapper){
        this.dao = dao;
        this.mapper = mapper;
    }


    // create
    @Override
    public EmployeeResponse createEmployee(EmployeeCreateDto createDto) {
        if(createDto.fullName().isBlank()){
            throw new EmployeeException("Name can't be blank");
        }
        if(createDto.hireDate().isAfter(LocalDate.now().minusYears(18))){
            throw new EmployeeException("Employee can't be below 18n or older");
        }

        Employee employee = mapper.fromEmployeeCreateDto(createDto);
        Employee savedEmployee = dao.save(employee);
        return mapper.toEmployeeResponse(savedEmployee);
    }

    // Update
    @Override
    public EmployeeResponse updateById(Long id, EmployeeUpdateDto dto) {

        Employee existingEmployee = dao.getById(id);
        if (existingEmployee == null) {
            throw new EmployeeException("Employee with ID " + id + " not found");
        }

        if (dto.fullName().isBlank()) {
            throw new EmployeeException("Name can't be blank");
        }

        if (dto.hireDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new EmployeeException("Employee can't be below 18");
        }
        existingEmployee.setFullName(dto.fullName());
        existingEmployee.setSalary(dto.salary());
        existingEmployee.setHireDate(dto.hireDate());
        Employee updatedEmployee = dao.updateById(id, existingEmployee);
        return mapper.toEmployeeResponse(updatedEmployee);
    }



    @Override
    public Boolean deleteById(Long id) {
        Employee existingEmployee = dao.getById(id);
        if (existingEmployee == null) {
            return false;
        }
        dao.deleteById(id);
        return true;
    }




    @Override
    public List<EmployeeResponse> getAllEmployee(int offset, int limit) {
        return dao.getAll(offset, limit)
                .stream()
                .map(mapper::toEmployeeResponse)
                .toList();
    }



    @Override
    public EmployeeResponse getById(Long id) {
        Employee employee = dao.getById(id);
        if (employee == null) {
            return null;
        }
        return mapper.toEmployeeResponse(employee);
    }

}
