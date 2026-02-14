package db;

import model.entities.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDb {
    private final List <Employee> employeeList;
    public EmployeeDb(){
        employeeList = new ArrayList<>(){{
            add(new Employee(
                    "Jennie",2000.00, LocalDate.now().minusDays(7)
            ));
            add(new Employee(
                    "Mona",3000.00, LocalDate.now().minusDays(7)
            ));
            add(new Employee(
                    "Pink Panther",5000.00, LocalDate.now().minusMonths(2)
            ));
            add(new Employee(
                    "Zhang Lurang",5000.00, LocalDate.now()
            ));
            add(new Employee(
                    "Sangyan",4500.00, LocalDate.now().minusDays(7)
            ));
            add(new Employee(
                    "Capybara",1400.00, LocalDate.now().minusMonths(2)
            ));
            add(new Employee(
                    "Su zaizai",200.00, LocalDate.now().minusDays(7)
            ));
            add(new Employee(
                    "Jiang Jia",1400.00, LocalDate.now().minusMonths(2)
            ));
            add(new Employee(
                    "Kevin", 2600.00, LocalDate.now().minusDays(8
            )));
            add(new Employee(
                    "Laura", 3400.00, LocalDate.now().minusMonths(5
            )));
            add(new Employee(
                    "Michael", 4500.00, LocalDate.now().minusDays(12
            )));
            add(new Employee(
                    "Nina", 3800.00, LocalDate.now().minusMonths(2
            )));
            add(new Employee(
                    "Oscar", 2700.00, LocalDate.now().minusDays(9
            )));
        }};
    }



    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
