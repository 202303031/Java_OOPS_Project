import java.util.Scanner;

public class PaymentService {
    public static boolean processPayment(double totalBill) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your total bill is: $" + totalBill);
        System.out.println("Select payment method:");
        System.out.println("1. Online Payment");
        System.out.println("2. Cash on Delivery");
        System.out.print("Enter your choice: ");
        int paymentMethod = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (paymentMethod == 1) {
            System.out.println("You have selected Online Payment.");
            System.out.println("Please provide the following card details:");
            System.out.print("Card Number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Name on Card: ");
            String nameOnCard = scanner.nextLine();
            System.out.print("Expiry Date (MM/YYYY): ");
            String expiryDate = scanner.nextLine();
            System.out.print("CVV: ");
            String cvv = scanner.nextLine();
            System.out.print("OTP (One-time Password): ");
            String otp = scanner.nextLine();

            System.out.println("Payment processed successfully!");
            return true;
        } else if (paymentMethod == 2) {
            System.out.println("You have selected Cash on Delivery. Payment will be collected during delivery.");
            System.out.print("Enter 'Y' to confirm or 'N' to cancel: ");
            String input = scanner.nextLine();
            return input.equalsIgnoreCase("Y");
        } else {
            System.out.println("Invalid choice. Payment canceled.");
            return false;
        }
    }
}