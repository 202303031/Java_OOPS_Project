import java.io.*;
import java.util.Scanner;

public class ProductService {
    private static final String PRODUCT_FILE_NAME = "product_data.txt";

    public static void displayAllProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILE_NAME))) {
            String line;
            System.out.println("Product Details:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\|");
                System.out.println("Product ID: " + parts[0].trim());
                System.out.println("Name: " + parts[1].trim());
                System.out.println("Price: " + parts[2].trim());
                System.out.println("Quantity: " + parts[3].trim());
                System.out.println("Description: " + parts[4].trim());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double orderProducts() {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILE_NAME))) {
            String line;
            StringBuilder updatedContent = new StringBuilder();
            System.out.println("Product Order:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\|");
                System.out.println("Product ID: " + parts[0]);
                System.out.println("Name: " + parts[1]);
                System.out.println("Price: " + parts[2]);
                System.out.println("Available Quantity: " + parts[3]);
                System.out.println();

                System.out.print("Enter the quantity to order for product " + parts[1] + ": ");
                int quantityOrdered = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                int availableQuantity = Integer.parseInt(parts[3].trim());
                if (quantityOrdered <= availableQuantity) {
                    double pricePerUnit = Double.parseDouble(parts[2].trim());
                    totalBill += quantityOrdered * pricePerUnit;

                    int updatedQuantity = availableQuantity - quantityOrdered;
                    parts[3] = String.valueOf(updatedQuantity);
                } else {
                    System.out.println("Error: Ordered quantity exceeds available quantity.");
                    System.out.println("Available quantity for " + parts[1] + " is " + availableQuantity);
                }

                updatedContent.append(String.join(" | ", parts)).append(System.lineSeparator());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCT_FILE_NAME))) {
                writer.write(updatedContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalBill;
    }
}