package org.classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Compare two strings");
            System.out.println("2. Exit");

            System.out.print("Enter your choice (1 or 2): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                anagramMenu(scanner);
            }
            else if (choice.equals("2")) {
                System.out.println("Exiting the program.");
                break;
            }
            else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        scanner.close();
    }

    public static void anagramMenu(Scanner scanner){
        AnagramChecker anagramChecker = new AnagramChecker();
        while(true){
            System.out.print("Enter the first string: ");
            String str1 = scanner.nextLine();
            System.out.print("Enter the second string: ");
            String str2 = scanner.nextLine();
            if(str1.matches("[a-zA-Z]+") || str2.matches("[a-zA-Z]+")){
                if (anagramChecker.areAnagrams(str1, str2)) {
                    System.out.println(str1 + " and " + str2 + " are anagrams.");
                }
                else {
                    System.out.println(str1 + " and " + str2 + " are not anagrams.");
                }
                break;
            }
            else {
                System.out.println("One of the strings entered contains a space, number and/or a special character please ensure the strings entered meet these requirements.");
            }
        }
    }
}