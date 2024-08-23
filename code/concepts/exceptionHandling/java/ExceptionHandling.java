/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Basic exception handling
 * Custome exceptions
 * Catching Multiple Unrelated Exceptions in a Single Block
 * Finally block
 * Re-throw exceptions
 * Handling Checked Exceptions
 *
 *******************************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionHandling {
    static class AgeException extends Exception {
        private int errorCode;

        public AgeException(String message, int inErrCode) {
            super(message);
            errorCode = inErrCode;
        }

        public int getErrorCode() {
            return errorCode;
        }
    }

    public static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("Age must be 18 or older.", 3002);
        }
        System.out.println("Age is valid.");
    }

    public static void throwMultiException(String input) {
        // Attempt to convert the input string to an integer
        int number = Integer.parseInt(input); // throws NumberFormatException

        // Check if the number is negative (IllegalArgumentException)
        if (number < 0) {
            throw new IllegalArgumentException("Negative number not allowed: " + number);
        }

        // Perform some arithmetic operation that could cause an ArithmeticException
        int result = 10 / number; // This will throw ArithmeticException if number is zero
        System.out.println("Result: " + result);
    }

    public static void main (String[] args) {
        // Handling ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
            //throw e; // Rethrow the exception
        }

        // Handling NullPointerException
        try {
            String nullStr = null;
            System.out.println(nullStr.length());
        } catch (NullPointerException e) {
            System.out.println("Null string access: " + e.getMessage());
        }

        // Handling ArrayIndexOutOfBoundsException
        try {
            int[] array = {10, 20, 30};
            System.out.println("Try to print content at index 5: " + array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } // Generic Exception catch should be at last
        catch (Exception e) {
            System.out.println("Catch any exception or rethrows");
        } finally {
            /*
             "finally" block used in exception handling to execute code regardless of 
             whether an exception is thrown or not.
            */
            System.out.println("I want this print even if there are exceptions");
        }

        // Handling FileNotFoundException
        String filePath = "path/to/your/fileName.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file was not found.");
            System.err.println("Printing stack trace: ");
            e.printStackTrace();
        }

        // Handling custom AgeException
        try {
            checkAge(10);
        } catch (AgeException e) {
            System.out.println("Caught an AgeException: " + e.getMessage() +
                               " with error code: " + e.getErrorCode());
        }

        // Catching Multiple Unrelated Exceptions in a Single Block
        String[] inputs = {"10", "abc", "-5", "20"};
        for (String input : inputs) {
            try {
                throwMultiException(input);
            } catch (NumberFormatException | ArithmeticException e) {
                // Catch unrelated exceptions in a single block
                System.err.println("Exception occurred: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                // Catch IllegalArgumentException separately as it is a subclass of NumberFormatException
                System.err.println("Illegal argument error: " + e.getMessage());
            }
        }
    }
}