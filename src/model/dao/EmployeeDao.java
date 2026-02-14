package model.dao;

import model.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee save(Employee employee);

    List<Employee> getAll(int offset, int limit);

    Employee getById(Long id);

    Employee updateById(Long id, Employee employee);

    boolean deleteById(Long id);


}
