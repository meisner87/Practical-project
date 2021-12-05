package menu;

import model.Customer;
import model.Employee;
import persistence.RepositoryCustomer;
import persistence.RepositoryDate;
import persistence.RepositoryEmployee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuEmployee {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();
    RepositoryEmployee repo = new RepositoryEmployee();
    RepositoryDate repositoryDate = new RepositoryDate();

    private int menuOptions(Scanner scanner) {
        System.out.println("\n/########## Employee MENU ##########/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all employees by date of birth");
        System.out.println("2: Save an employee");
        System.out.println("3: Update employee by Id" + "");
        System.out.println("4: List all employees between certain date");
        System.out.println("5: List all employees");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/###################################/");
        return scanner.nextInt();
    }

    protected void menuChoice(Scanner scanner) {

        int userChoice;
        do {
            userChoice = menuOptions(scanner);
            switch (userChoice) {
                case 1:
                    listAllEmployeesByDob(scanner);
                    break;
                case 2:
                    saveNewEmployee(scanner, repo);
                    break;
                case 3:
                    updateEmployeeByAddress(scanner, repo);
                    break;
                case 4:
                    listAllEmployeesByCertainDate();
                    break;
                case 5:
                    listTotalEmployee();
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(scanner);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }


    private void menuListAllCustomers(Scanner scanner) {
        List<Customer> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            //menuOptions(scanner);
        }
    }

    private void saveNewEmployee(Scanner scanner, RepositoryEmployee repo) {
        String firstName;
        do {
            System.out.println("Employee name has only letters from a-Z");
            System.out.println("First name : ");
            firstName = scanner.next();
        } while (!firstName.matches("[a-zA-Z]{3,30}+"));

        String lastName;
        do {
            System.out.println("Employee name has only letters from a-Z");
            System.out.println("Last name : ");
            lastName = scanner.next();
        } while (!lastName.matches("[a-zA-Z]{3,30}+"));

        String address;
        do {
            System.out.println("Address name has only letters from a-Z");
            System.out.println("Address : ");
            address = scanner.next();
        } while (!address.matches("[a-zA-Z]{3,30}+"));


        System.out.println("Enter the date of birth like : 2000-01-01");
        DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());

        LocalDate register = LocalDate.now();
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAddress(address);
        employee.setDob(dateOfBirth);
        employee.setDateOfRegister(register);
        //repo.saveEmployee(employee);
        repo.updateEmployeeAddressById(employee.getEmployeeId(), address);

    }


    public void updateEmployeeByAddress(Scanner scanner, RepositoryEmployee repo) {
        Employee employee = new Employee();
        System.out.println("Type the employee id to update the address");
        int id = scanner.nextInt();
        if (employee == null) {
            System.out.println("This employee is not registered in out company");
        } else {
            System.out.println("Type the new address");
            String address = scanner.next();
            employee.setAddress(address);
            repo.updateEmployeeAddressById(id, address);
        }
    }

    private void listAllEmployeesByDob(Scanner scanner) {
        List<Employee> listEmployeesByDob = repositoryDate.employeesByDateOfBirth();

        if (listEmployeesByDob.size() > 0) {
            System.out.println("\nList of employees:");
            for (Employee emp : listEmployeesByDob) {
                System.out.println(emp.toString());
            }
        } else {
            System.out.println("\nNo employees registered\n");

        }
    }

    private void listAllEmployeesByCertainDate() {
        System.out.println("List emp by date");
        List<Employee> listEmployeesBetween = repositoryDate.employeesBetween();
        for (Employee emp: listEmployeesBetween) {
            System.out.println(emp.getFirstName());
        }
    }

    public void listTotalEmployee() {
        long result = repo.listTotalEmployees();
        System.out.println("Total of employees " + result);
    }


}







