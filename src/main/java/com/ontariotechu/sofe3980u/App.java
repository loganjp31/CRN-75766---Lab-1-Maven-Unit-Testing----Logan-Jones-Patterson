package com.ontariotechu.sofe3980u;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first binary number: ");
        Binary num1 = new Binary(scanner.nextLine());

        System.out.print("Enter second binary number: ");
        Binary num2 = new Binary(scanner.nextLine());

        System.out.println("\nChoose an operation:");
        System.out.println("1 - ADD");
        System.out.println("2 - OR");
        System.out.println("3 - AND");
        System.out.println("4 - MULTIPLY");

        int choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                Binary sum = Binary.add(num1, num2);
                System.out.println("ADD result: " + sum.getValue());
                break;

            case 2:
                Binary.or(num1, num2);
                break;

            case 3:
                Binary.and(num1, num2);
                break;

            case 4:
                Binary.multiply(num1, num2);
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
