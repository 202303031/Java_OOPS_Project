import java.io.*;

public class EmployeeService {
    private static final String EMPLOYEE_FILE_NAME = "employee_data.txt";

    public static void searchEmployeeById(int searchId) {
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\|");
                int employeeId = Integer.parseInt(parts[0].trim());
                if (searchId == employeeId) {
                    found = true;
                    System.out.println("Employee found:");
                    System.out.println("ID: " + parts[0]);
                    System.out.println("Name: " + parts[1]);
                    System.out.println("Designation: " + parts[2]);
                    System.out.println("Department: " + parts[3]);
                    System.out.println("Phone: " + parts[4]);
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendNewEmployee(int id, String name, String designation, String department, String phone) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE_NAME, true))) {
            String entry = id + " | " + name + " | " + designation + " | " + department + " | " + phone;
            writer.newLine();
            writer.write(entry);
            System.out.println("New employee added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}