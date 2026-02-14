package model.entities;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {

    private Long id;
    private String fullName;
    private Double salary;
    private LocalDate hireDate;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public Employee(String fullName, Double salary, LocalDate hireDate) {
        this.id = new Random().nextLong(999);
        this.fullName = fullName;
        this.salary = salary;
        this.hireDate = hireDate;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

}