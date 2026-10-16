package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                case "0" -> running = false;
            }
        }

    }
}