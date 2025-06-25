// --- File: FactoryModel.java ---
import java.util.Scanner;

public class FactoryModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("Welcome to Employee Manager");
            System.out.println("1. Search Employee by ID");
            System.out.println("2. Add New Employee");
            System.out.println("3. Display Machine Details");
            System.out.println("4. Display Product Details");
            System.out.println("5. Order Products");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Employee ID to search:");
                    int searchId = scanner.nextInt();
                    EmployeeService.searchEmployeeById(searchId);
                    break;
                case 2:
                    System.out.println("Enter Employee ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Employee Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Employee Designation:");
                    String designation = scanner.nextLine();
                    System.out.println("Enter Employee Department:");
                    String department = scanner.nextLine();
                    System.out.println("Enter Employee Phone:");
                    String phone = scanner.nextLine();
                    EmployeeService.appendNewEmployee(id, name, designation, department, phone);
                    break;
                case 3:
                    System.out.println("Enter the Machine ID to search:");
                    scanner.nextLine(); // Consume newline
                    String machineId = scanner.nextLine();
                    MachineService.displayMachineDetails(machineId);
                    break;
                case 4:
                    ProductService.displayAllProducts();
                    break;
                case 5:
                    double bill = ProductService.orderProducts();
                    if (bill > 0) {
                        boolean paymentProcessed = PaymentService.processPayment(bill);
                        if (paymentProcessed) {
                            System.out.println("Payment processed successfully. Order placed!");
                        } else {
                            System.out.println("Payment canceled. Order not placed.");
                        }
                    } else {
                        System.out.println("No products ordered. Exiting order process.");
                    }
                    break;
                case 6:
                    exitRequested = true;
                    System.out.println("Exiting FactoryModel. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
