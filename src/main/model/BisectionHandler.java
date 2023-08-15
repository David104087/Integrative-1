package main.model;

/**
 * The Bisection class provides a function to apply the bisection method on an interval to find the root of a function
 */
public class BisectionHandler {

    private static MathModule mathModule = new MathModule();

    /**
     * The methodBisection method applies the bisection method to find the root of
     * the chosen function
     * 
     * @param a      the lower limit of the interval
     * @param b      the upper limit of the interval
     * @param function the option of the function selected by the user
     */
    public static double compute(double a, double b, int function) {

        double c = 0;
        double epsilon = 0.00001;

        if (mathModule.doF(function, a) * mathModule.doF(function, b) > 0) {
            System.out.println("Invalid range");
        } else {
            do {
                if (mathModule.doF(function, a) * mathModule.doF(function, b) < 0) {
                    c = (a + b) / 2;
                    if (mathModule.doF(function, a) * mathModule.doF(function, c) < 0) {
                        b = c;
                    } else {
                        a = c;
                    }
                }

            } while (mathModule.abs(mathModule.doF(function, c)) > epsilon);
        }
        return c;
    }
}