package dto;


import lombok.Builder;
import java.time.LocalDate;

@Builder
public record EmployeeResponse(
        Long id,
        String fullName,
        Double salary,
        LocalDate hireDate
) {

}
