package view;

import dto.*;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static final Scanner scanner = new Scanner(System.in);

    public EmployeeCreateDto displayCreateRequest(  ){
        System.out.print("[+] Enter Employee Name: ");
        String fullName = scanner.nextLine();

        System.out.print("[+] Enter Employee Salary: ");
        Double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("[+] Enter Hire Date(Format yyyy-mm-dd): ");
        String hireDateStr = scanner.nextLine();

        String [] parts = hireDateStr.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate hireDate = LocalDate.of(year, month, day);
        return new EmployeeCreateDto(fullName,salary,hireDate);
    }

    public EmployeeUpdateDto displayUpdateRequest() {
        System.out.print("[+] Enter Employee ID to update: ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.print("[+] Enter Employee Name: ");
        String fullName = scanner.nextLine();

        System.out.print("[+] Enter Employee Salary: ");
        Double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("[+] Enter Hire Date (Format yyyy-mm-dd): ");
        String hireDateStr = scanner.nextLine();

        String[] parts = hireDateStr.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate hireDate = LocalDate.of(year, month, day);

        return new EmployeeUpdateDto(id, fullName, salary, hireDate);
    }



    public EmployeeDeleteDto displayDeleteRequest() {
        System.out.print("[+] Enter Employee ID to delete: ");
        Long id = Long.parseLong(scanner.nextLine());
        return new EmployeeDeleteDto(id);
    }
    public Long displayGetByIdRequest() {
        System.out.print("[+] Enter Employee ID: ");
        return Long.parseLong(scanner.nextLine());

    }




    public int showMenuAndGetOption(){
        System.out.println("""
               
               
               Employee Management System
               
               1. Create Employee
               2. Get All
               3. Get By ID
               4. Update Employee
               5. Delete Employee
               6. Set up page size
               7. Go to page
               8. Next page
               9. Previous page
               0. Exit
               """);
        System.out.print("Choose an option: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayEmployeeTable( List<EmployeeResponse> responses){
        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        String [] columns ={"ID","Full Name","Salary","Hire Date"};
        for(String column: columns){
            table.addCell(column);
        }
        responses.forEach(employee->{
            table.addCell(employee.id().toString());
            table.addCell(employee.fullName());
            table.addCell(employee.salary().toString());
            table.addCell(employee.hireDate().toString());

        });

        System.out.println(table.render());

    }
    public void displaySingleEmployee(EmployeeResponse response) {
        Table table = new Table(
                4, BorderStyle.CLASSIC
        );
        table.addCell(
                " Employee Information ",
                new CellStyle(CellStyle.HorizontalAlign.center),
                4
        );
        table.addCell(" ID ");
        table.addCell(response.id().toString(), 3);
        table.addCell(" Full Name ");
        table.addCell(response.fullName(), 3);
        table.addCell(" Salary ");
        table.addCell(response.salary().toString(), 3);
        table.addCell(" Hire Date ");
        table.addCell(response.hireDate().toString(), 3);

        System.out.println(table.render());
    }

}
