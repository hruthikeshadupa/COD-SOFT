import java.util.Scanner;

public class Task4_CurrencyConverter{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CURRENCY CONVERTER =====");

        System.out.println("Available Currencies:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. INR (Indian Rupee)");
        System.out.println("3. EUR (Euro)");
        System.out.println("4. GBP (British Pound)");

        System.out.print("\nSelect Base Currency (1-4): ");
        int base = scanner.nextInt();

        System.out.print("Select Target Currency (1-4): ");
        int target = scanner.nextInt();

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(base, target);

        if (rate == -1) {
            System.out.println("Invalid Currency Selection!");
        } else {
            double convertedAmount = amount * rate;

            System.out.println("\n===== CONVERSION RESULT =====");
            System.out.println("Amount: " + amount);
            System.out.println("Converted Amount: " + convertedAmount + " "
                    + getCurrencyCode(target));
        }

        scanner.close();
    }

    public static double getExchangeRate(int base, int target) {

        if (base == target)
            return 1.0;

        // Sample exchange rates
        if (base == 1 && target == 2) return 86.0;    // USD → INR
        if (base == 2 && target == 1) return 0.0116;  // INR → USD

        if (base == 1 && target == 3) return 0.85;    // USD → EUR
        if (base == 3 && target == 1) return 1.18;    // EUR → USD

        if (base == 1 && target == 4) return 0.74;    // USD → GBP
        if (base == 4 && target == 1) return 1.35;    // GBP → USD

        if (base == 2 && target == 3) return 0.0099;  // INR → EUR
        if (base == 3 && target == 2) return 101.0;   // EUR → INR

        if (base == 2 && target == 4) return 0.0086;  // INR → GBP
        if (base == 4 && target == 2) return 116.0;   // GBP → INR

        if (base == 3 && target == 4) return 0.87;    // EUR → GBP
        if (base == 4 && target == 3) return 1.15;    // GBP → EUR

        return -1;
    }

    public static String getCurrencyCode(int choice) {
        switch (choice) {
            case 1: return "USD";
            case 2: return "INR";
            case 3: return "EUR";
            case 4: return "GBP";
            default: return "";
        }
    }
}