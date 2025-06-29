import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Please select an option (1-4): ");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                performDeposit();
                break;
            case 3:
                performWithdrawal();
                break;
            case 4:
                System.out.println("Thank you for using our ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", userAccount.getBalance()));
    }

    private void performDeposit() {
        System.out.print("Enter deposit amount: $");
        try {
            double amount = scanner.nextDouble();
            userAccount.deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the scanner buffer
        }
    }

    private void performWithdrawal() {
        System.out.print("Enter withdrawal amount: $");
        try {
            double amount = scanner.nextDouble();
            userAccount.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the scanner buffer
        }
    }
}