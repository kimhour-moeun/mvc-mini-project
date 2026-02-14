package model.dao;

import db.EmployeeDb;
import model.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    private final EmployeeDb employeeDb;


    public EmployeeDaoImpl(EmployeeDb employeeDb) {
        this.employeeDb = employeeDb;
    }


    @Override
    public Employee save(Employee employee) {
        employeeDb.getEmployeeList().add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll(int offset, int limit) {
        List<Employee> all = employeeDb.getEmployeeList();
        if (offset < 0) {
            offset = 0;
        }
        int end = Math.min(offset + limit, all.size());
        if (offset >= all.size()) {
            return new ArrayList<>();
        }
        return all.subList(offset, end);
    }


    @Override
    public Employee getById(Long id) {
        return employeeDb.getEmployeeList()
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public Employee updateById(Long id, Employee employee) {
        List<Employee> employees = employeeDb.getEmployeeList();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employee.setId(id);
                employees.set(i, employee);
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return employeeDb.getEmployeeList()
                .removeIf(employee -> employee.getId().equals(id));
    }
}
