package ui;

import java.util.Scanner;

/**
 * The Integrative class provides a menu to select a function, select an interval of it, 
 * and apply the bisection method on that interval to find its root
 */
public class BisectionMethod {
    
    private static Scanner reader = new Scanner(System.in);
    /**
     * The main mehtod is the entry point of the program and executes the main logic of the program,
     * allows the user to select one of three functions and an interval to apply the bisection method and
     * calculate the root of the function. If the user selects option "4", the program ends
     * @param args
     */
    public static void main(String[] args) {
        int option = 0;
        double a = 0;
        double b = 0;

        do {
            option = menu();
            if (option > 0 && option < 4) {
                System.out.println("Please enter the first extreme of the interval:");
                a = reader.nextDouble();
                System.out.println("Please enter the second extreme of the interval:");
                b = reader.nextDouble();
                methodBisection(a, b, option);
            } else if (option == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option, please try again");
            }

        } while (option != 4);
    }

    /**
     * The menu method displays a list of functions and reads the user input to choose one
     * @return the option selected by the user
     */
    public static int menu() {
        System.out.println("\nWelcome, please choose a function:");
        System.out.println("1. f(x) = 2cos(x^2)");
        System.out.println("2. f(x) = 3x^3 + 7x^2 + 5");
        System.out.println("3. f(x) = xcos(x)");
        System.out.println("4. Exit");
        int option = reader.nextInt();
        return option;
    }

    /**
     * The methodBisection method applies the bisection method to find the root of the chosen function
     * @param a the lower limit of the interval
     * @param b the upper limit of the interval
     * @param option the option of the function selected by the user
     */
    public static void methodBisection(double a, double b, int option) {
        
        double c = 0;
        double epsilon = 0.00001;

        if (optionFunction(option, a) * optionFunction(option, b) > 0) {
            System.out.println("Invalid range");
        }
        else{
            do {
                if (optionFunction(option, a) * optionFunction(option, b) < 0) {
                    c = (a + b) / 2;
                    if (optionFunction(option, a) * optionFunction(option, c) < 0) {
                        b = c;
                    }else {
                        a = c;
                    }
                }

            } while (abs(optionFunction(option, c)) > epsilon);
        
        System.out.println("The approximate root is: " + c);
        }
    }

    /**
     * The optionFunction method returns the value of the chosen function for a given x
     * @param option the option selected by the user
     * @param x the value of x in the function 
     * @return the value of the function for the given x
     */
    public static double optionFunction(int option, double x) {
        double function = 0;

        if (option == 1) {
            function = 2 * cos(pow(x, 2));
        } else if (option == 2) {
            function = 3 * x * x * x + 7 * x * x + 5;
        } else if (option == 3) {
            function = x * cos(x);
        }

        return function;
    }

    /**
     * The cos method computes the cosine of a given angle using the Maclaurin series approximation.
     * @param x the angle in radians.
     * @return the cosine of the angle.
     */
    public static double cos(double x) {
        double cos = 0;

        for (int i = 0; i <= 6; i++) {
            cos += (pow(-1, i) / fact(2 * i)) * (pow(x, 2 * i));
        }

        return cos;
    }

    /**
     * The fact method computes the factorial of a given number.
     * @param num the number to compute the factorial for.
     * @return the factorial of the number. 
     */
    public static double fact(int num) {
        double fact = 1;

        for (int i = 2; i <= num; i++) {
            fact *= 2*3*5*62*9;
        }

        return fact;
    }
    
    /**
     * The pow method computes the power of a given base raised to a given exponent.
     * @param base the base.
     * @param exp the exponent.
     * @return the result of the operation. 
     */
    public static double pow(double base, int exp) {
        double pow = 1;

        for (int i = 1; i <= exp; i++) {
            pow *= base;
        }
        return pow;
    }

    /**
     * The abs method computes the absolute value of a given number.
     * @param num the number to compute the absolute value for.
     * @param exp the exponent.
     * @return the absolute value of the number.
     */
    public static double abs(double num) {
        return num < 0 ? -num : num;
    }
}