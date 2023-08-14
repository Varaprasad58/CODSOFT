import java.util.*;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM() {
        this.bankAccount = new BankAccount(1000); // Set an initial balance for demonstration purposes
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the ATM!");
        showMenu();

        int option;
        do {
            option = getUserOption();
            switch (option) {
                case 1:
                    withdrawFunds();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private int getUserOption() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter your choice (as a number): ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void withdrawFunds() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = getValidAmount();

        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: Rs:" + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private void depositFunds() {
        System.out.print("Enter the amount to deposit: ");
        double amount = getValidAmount();

        bankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: Rs:" + bankAccount.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance: Rs:" + bankAccount.getBalance());
    }

    private double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid amount: ");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        while (amount <= 0) {
            System.out.print("Invalid amount. Enter a positive value: ");
            amount = scanner.nextDouble();
        }
        return amount;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
