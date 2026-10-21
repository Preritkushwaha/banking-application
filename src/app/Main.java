package app;

import service.BankService;
import service.impl.BankServiceImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankService bankService = new BankServiceImpl();

        boolean running = true;

        System.out.println("Welcome to Console Bank");

        while (running){
            System.out.println("""
                1) OPEN ACCOUNT
                2) DEPOSIT
                3) WITHDRAW
                4) TRANSFER
                5) ACCOUNT STATEMENT
                6) LIST ACCOUNTS
                7) SEARCH ACCOUNTS BY CUSTOMER NAME
                0) EXIT
            """);
            System.out.print("CHOOSE: ");
            String choice = scanner.nextLine().trim();
            System.out.println("CHOICE: " + choice);

            switch (choice) {
                case "1" -> openAccount(scanner, bankService);
                case "2" -> deposit(scanner, bankService);
                case "3" -> withdraw(scanner, bankService);
                case "4" -> transfer(scanner);
                case "5" -> accountStatement(scanner);
                case "6" -> listStatement(scanner, bankService);
                case "7" -> searchAccounts(scanner);
                case "0" -> running = false;
            }
        }

    }

    private static void openAccount(Scanner scanner, BankService bankService) {
        System.out.println("Customer name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (SAVING/CURRENT): ");
        String accountType = scanner.nextLine().trim();
        System.out.println("Initial deposit (optional, blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        Double initial = Double.valueOf(amountStr);

        String acNum = bankService.openAccount(name, email, accountType);
        if(initial > 0){
            bankService.deposit(acNum, initial, "Initial Deposit");
        }
        System.out.println("Account Opened: " + acNum);
    }

    private static void accountStatement(Scanner scanner) {
    }

    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        double amount = scanner.nextInt();
        bankService.deposit(accountNumber, amount, "Deposit");
        System.out.println("Deposited");
    }

    private static void withdraw(Scanner scanner, BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        double amount = scanner.nextInt();
        bankService.withdraw(accountNumber, amount, "Withdraw");
        System.out.println("Withdrawn");
    }

    private static void transfer(Scanner scanner) {
    }

    private static void listStatement(Scanner scanner, BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }

    private static void searchAccounts(Scanner scanner) {

    }


}