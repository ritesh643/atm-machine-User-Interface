import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with initial balance of $1000
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        
        // Run the ATM interface in a loop
        while (true) {
            atm.displayMenu();
            try {
                int option = new Scanner(System.in).nextInt();
                atm.processOption(option);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }
}