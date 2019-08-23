package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean running = true;


        ValidityChecker checker = new ValidityChecker("19780202-2389");
        checker.addValidityCheck("notnull");
        checker.addValidityCheck("notempty");
        checker.addValidityCheck("personalnumber");
        checker.addValidityCheck("personalnumberformat");

        checker.runValidations();

//        while (running) {
//
//            System.out.println("Enter your personal number in the format 'YYYYMMDD-NNNN'");
//            String personNummer = scanner.nextLine();
//            PersonalNumberCheck check = new PersonalNumberCheck("19780202-2389");
//            System.out.println("Type exit to exit or press enter if you want to run again:");
//            if (scanner.nextLine().equalsIgnoreCase("EXIT")) {
//                running = false;
//            }
//        }
    }
}
