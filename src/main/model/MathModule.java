package main.model;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

/**
 * The MathModule class is a Java class that provides mathematical functions and operations.
 */
public class MathModule {

    private List<Function<Double, Double>> functions;

    public MathModule() {
        functions = new ArrayList<>();
        functions.add((x) -> 2 * cos(pow((Double) x, 2)));
        functions.add((x) -> 3 * pow((Double) x, 3) + 7 * pow((Double) x, 2) + 5);
        functions.add((x) -> (Double) x * cos((Double) x));
    }
    
    public List<Function<Double, Double>> getFunctions() {
        return functions;
    }
    
    /**
     * The function "doF" takes an index and a double value as input, and returns the result of
     * applying a specific mathematical function to the input value.
     * 
     * @param index The index parameter represents the index of a function in an array of functions. It
     * is used to select a specific function to apply to the input value x. The index should be an
     * integer value between 1 and 3, inclusive.
     * @param x The parameter "x" is a double value that represents the input value for the function.
     * @return The method is returning the result of applying the function at the specified index to
     * the given value of x.
     */
    public double doF(int index, double x) {
        if (index < 1 || index > 3) {
            throw new IllegalArgumentException("Invalid index. Allowed values are 1 to 3.");
        }

        return functions.get(index - 1).apply(x);
    }

    /**
     * The above function computes the cosine of a given angle using the Taylor series approximation.
     * 
     * @param x The parameter "x" in the above code represents the angle in radians for which you want
     * to calculate the cosine value.
     * @return The method is returning the value of the cosine of the input parameter x.
     */
    public  double cos(double x) {
        double cos = 0;
        for (int i = 0; i <= 10; i++) {
            cos += (pow(-1, i) / factorial(2 * i)) * (pow(x, 2 * i));
        }
        return cos;
    }

    /**
     * The factorial function calculates the factorial of a given number recursively.
     * 
     * @param num The parameter "num" is an integer representing the number for which we want to
     * calculate the factorial.
     * @return The factorial of the given number.
     */
    public  double factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    /**
     * The function calculates the power of a given base raised to a given exponent.
     * 
     * @param base The base is the number that will be raised to the power of the exponent.
     * @param exp The "exp" parameter represents the exponent to which the "base" number is raised.
     * @return The method is returning the result of raising the base to the power of the exponent.
     */
    public  double pow(double base, int exp) {
        double pow = 1;

        for (int i = 1; i <= exp; i++) {
            pow *= base;
        }

        return pow;
    }

    
    /**
     * The function returns the absolute value of a given number.
     * 
     * @param num The parameter "num" is a double data type, which represents a decimal number.
     * @return The absolute value of the input number.
     */
    public  double abs(double num) {
        return num < 0 ? -num : num;
    }
}
