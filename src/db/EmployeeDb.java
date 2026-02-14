package db;

import model.entities.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDb {
    private final List <Employee> employeeList;
    public EmployeeDb(){
        employeeList = new ArrayList<>(){{
            add(new Employee("Lionel Messi", 7500.00, LocalDate.now().minusDays(10)));
            add(new Employee("Cristiano Ronaldo", 7200.00, LocalDate.now().minusMonths(2)));
            add(new Employee("Kylian Mbappé", 6800.00, LocalDate.now().minusDays(5)));
            add(new Employee("Erling Haaland", 6500.00, LocalDate.now().minusDays(7)));
            add(new Employee("Neymar Jr", 6400.00, LocalDate.now().minusMonths(3)));
            add(new Employee("Kevin De Bruyne", 6000.00, LocalDate.now().minusDays(8)));
            add(new Employee("Luka Modrić", 5800.00, LocalDate.now().minusMonths(1)));
            add(new Employee("Robert Lewandowski", 5700.00, LocalDate.now().minusDays(12)));
            add(new Employee("Virgil van Dijk", 5400.00, LocalDate.now().minusDays(6)));
            add(new Employee("Harry Kane", 5300.00, LocalDate.now().minusMonths(4)));
            add(new Employee("Mohamed Salah", 5200.00, LocalDate.now().minusDays(9)));
            add(new Employee("Karim Benzema", 5100.00, LocalDate.now().minusDays(11)));
            add(new Employee("Bruno Fernandes", 4800.00, LocalDate.now().minusMonths(2)));
            add(new Employee("Pedri", 4500.00, LocalDate.now().minusDays(3)));
            add(new Employee("Gavi", 4400.00, LocalDate.now().minusDays(13)));
            add(new Employee("Jude Bellingham", 4300.00, LocalDate.now().minusMonths(5)));
            add(new Employee("Vinícius Júnior", 4200.00, LocalDate.now().minusDays(7)));
            add(new Employee("Marcus Rashford", 4000.00, LocalDate.now().minusMonths(2)));
            add(new Employee("Bukayo Saka", 3900.00, LocalDate.now().minusDays(14)));
            add(new Employee("Son Heung-min", 3700.00, LocalDate.now().minusDays(10)));

        }};
    }



    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
