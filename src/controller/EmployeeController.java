package controller;

import db.EmployeeDb;
import dto.*;
import model.service.EmployeeService;
import view.EmployeeView;

import java.util.List;
import java.util.Scanner;


public class EmployeeController {
    private int pageSize = 5;
    private int currentPage = 1;
    Scanner scanner = new Scanner(System.in);
    private final EmployeeView view;
    private final EmployeeService service;

    public EmployeeController(EmployeeView view, EmployeeService service){
        this.view = view;
        this.service = service;
    }

    public void create() {
        EmployeeCreateDto createDto = view.displayCreateRequest();
        EmployeeResponse response = service.createEmployee(createDto);
        view.displaySingleEmployee(response);


    }

    public void update() {
        EmployeeUpdateDto updateDto = view.displayUpdateRequest();
        EmployeeResponse response = service.updateById(updateDto.id(), updateDto);
        view.displaySingleEmployee(response);

    }

    public void displayEmployees() {

        EmployeeDb employeeDb = new EmployeeDb();
        int size = employeeDb.getEmployeeList().size();
        int totalPages = (size + pageSize - 1) / pageSize;
        int offset = (currentPage - 1) * pageSize;
        List<EmployeeResponse> employeeList =
                service.getAllEmployee(offset, pageSize);
        view.displayEmployeeTable(employeeList);
        System.out.println("===Page " + currentPage + " of " + totalPages + "===");
    }



    public void nextPage() {

        EmployeeDb employeeDb = new EmployeeDb();
        int size = employeeDb.getEmployeeList().size();
        int totalPages = (size + pageSize - 1) / pageSize;
        if (currentPage < totalPages) {
            currentPage++;
        }
        displayEmployees();
    }


    public void previousPage() {

        if (currentPage > 1) {
            currentPage--;
        }
        displayEmployees();
    }

    public void goToPage() {

        System.out.print("[+] Enter page number to go to: ");
        int page = scanner.nextInt();
        EmployeeDb employeeDb = new EmployeeDb();
        int size = employeeDb.getEmployeeList().size();
        int totalPages= (size+pageSize -1 )/pageSize;
        if (page >= 1 && page <= totalPages) {
            currentPage = page;
            displayEmployees();
        } else {
            System.out.println("===Page must be between 1 and " + totalPages);
        }
    }


    public void delete() {

        EmployeeDeleteDto deleteDto = view.displayDeleteRequest();
        Long id = deleteDto.id();
        Boolean response = service.deleteById(id);
        if (response) {
            System.out.println("=== Employee with ID " + id + " has been deleted successfully.===");
        } else {
            System.out.println("=== Employee with ID " + id + " was not found.===");
        }
    }


    public void getById() {
        Long id = view.displayGetByIdRequest();
        EmployeeResponse employeeResponse = service.getById(id);
        view.displaySingleEmployee(employeeResponse);
    }


    public void setPageSize() {
        System.out.print("[+] Enter new page size: ");
        try {
            int newSize = scanner.nextInt();
            scanner.nextLine();

            if (newSize <= 0) {
                System.out.println("[-] Page size must be greater than 0.");
                return;
            }
            pageSize = newSize;
            currentPage = 1;
            System.out.println("[+] Page size updated to " + pageSize);
            displayEmployees();
        } catch (Exception e) {
            System.out.println("[-] Invalid number!");
            scanner.nextLine();
        }
    }


    public void run(){
        while(true){
           int option=  view.showMenuAndGetOption();
           switch(option){
               case 1-> create();
               case 2-> {
                   pageSize = 5;
                   currentPage = 1;
                   displayEmployees();
               }
               case 3-> getById();
               case 4-> update();
               case 5-> delete();
               case 6-> setPageSize();
               case 7-> goToPage();
               case 8-> nextPage();
               case 9-> previousPage();
               case 0-> {
                   System.out.println("Exiting.....");
                   System.exit(0);

                   }
               }
            }
        }
    }

