import java.io.*;

public class MachineService {
    private static final String MACHINE_FILE_NAME = "machine_data.txt";

    public static void displayMachineDetails(String searchId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MACHINE_FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\|");
                if (searchId.trim().equals(parts[0].trim())) {
                    found = true;
                    System.out.println("Machine found:");
                    System.out.println("ID: " + parts[0]);
                    System.out.println("Type: " + parts[1]);
                    System.out.println("Manufacturer: " + parts[2]);
                    System.out.println("Model: " + parts[3]);
                    System.out.println("Status: " + parts[4]);
                    System.out.println("Operating Hours: " + parts[5]);
                    System.out.println("Maintenance Schedule: " + parts[6]);
                    break;
                }
            }
            if (!found) {
                System.out.println("Machine with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}