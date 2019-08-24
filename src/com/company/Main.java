package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Enter your personal number in the format 'YYYYMMDD-NNNN'");
            String personNummer = scanner.nextLine();
            ValidityChecker checker = new ValidityChecker(personNummer);
            System.out.println("Now enter what checks you want to run (Enter a number en press Enter):");
            boolean selecting = true;
            while (selecting) {
                System.out.println("1. Check that the input is not null");
                System.out.println("2. Check that the input is not empty");
                System.out.println("3. Check that the input is a correctly formatted personal number");
                System.out.println("4. Check that the input is a valid personal number");
                System.out.println("5. Done! Run validations. ");
                String selection = scanner.nextLine();
                if (selection.equals("1")) {
                    checker.addValidityCheck("NOTNULL");
                }else if (selection.equals("2")){
                    checker.addValidityCheck("NOTEMPTY");
                }else if (selection.equals("3")){
                    checker.addValidityCheck("PERSONALNUMBERFORMAT");

                }else if (selection.equals("4")){
                    checker.addValidityCheck("PERSONALNUMBER");

                }else if (selection.equals("5")){
                    if(checker.isValid()){
                        System.out.println(Integer.toString(checker.getNumberOfChecks()) + " checks were ran and the entered Personal Number is VALID");
                    } else {
                        System.out.println(Integer.toString(checker.getNumberOfChecks()) + " checks were ran and the entered Personal Number was INVALID");
                    }
                    selecting = false;
                }else {
                    System.out.println("Not a valid selection");
                }
            }


            System.out.println("Type exit to exit or press enter if you want to run again:");
            if (scanner.nextLine().equalsIgnoreCase("EXIT")) {
                running = false;
            }
        }
    }
}
