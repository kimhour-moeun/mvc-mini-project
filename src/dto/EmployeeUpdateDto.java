package dto;

import lombok.Builder;

import java.time.LocalDate;

public record EmployeeUpdateDto(
        Long id,
        String fullName,
        Double salary,
        LocalDate hireDate
) {

}
