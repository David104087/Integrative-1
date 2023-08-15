package main;
import java.util.Scanner;

import main.model.BisectionHandler;

public class BisectionApp {
    
    private static Scanner in = new Scanner(System.in);
    private static final String INIT_MESSAGE = "Welcome to the Bisection Method app!\n" +
            "You will select a function f(x) and then define an interval [a, b].\n" +
            "The app will apply the bisection method to find a root of the f(x) in [a, b].\n";

    /**
     * Allows the user to select one of the three functions and an 
     * interval to apply the bisection method and calculate the root of the function.
     * 0 exits the program
     * @param args
     */
    public static void main(String[] args) {
        int function = 0;
        double a, b = 0;

        do {
            System.out.println(INIT_MESSAGE);
            printMenu();
            function = readSafeInt();

            if (function > 0 && function < 4) {
                a = readSafeDouble("a:");

                b = readSafeDouble("b:");
                
                System.out.println("Result: " + BisectionHandler.compute(a, b, function));

            } else if (function == 0) {
                System.out.println("\nExiting Bisection App.\nGoodbye!\n");
            } else {
                System.out.println("Please choose a valid function.");
            }

        } while (function != 0);
    }
    
    /**
     * The menu method displays a list of functions to choose from
     * 
     */
    public static void printMenu() {
        System.out.println("Function:");
        System.out.println("1. f(x) = 2cos(x^2)");
        System.out.println("2. f(x) = 3x^3 + 7x^2 + 5");
        System.out.println("3. f(x) = xcos(x)");
        System.out.println("0. Exit");
    }

    public static int readSafeInt() {
        int input = -1;
        try {
            System.out.print("$ ");
            input = Integer.valueOf(in.nextLine());
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong. Please try again.");
        }
        return input;
    }

    public static double readSafeDouble(String valName) {
        double input = 0;
        try {
            System.out.print(valName + " ");
            input = Double.valueOf(in.nextLine());
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong. Please try again.");
        }
        return input;
    }

}
