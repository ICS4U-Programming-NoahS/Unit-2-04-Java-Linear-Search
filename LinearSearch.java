import java.util.Arrays;
import java.util.Scanner;

/**
* The Populating Arrays program will create 5
* different arrays of 10 random numbers
* with 10 random numbers between 0 and 100 on a line separated by spaces.
* It uses the Arrays.sort function to sort each array.
* It displays the sorted arrays and for each sorted array, writes the average.
*
r* @version 1.0
* @since 2025-03-17
*/

final class LinearSearch {

    /**
     * This is the array length.
     */
    public static final int ARRAY_LENGTH = 10;

    /**
     * This is the minimum number.
     */
    public static final int MAX_NUM = 100;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private LinearSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the populating arrays method.
     *
     * @return array of random numbers
     *
     */

    public static int[] populatingArrays() {

        // Create an array of numbers
        int[] arrayNum = new int[ARRAY_LENGTH];

        // Write a random number to the array of numbers
        // until 10 numbers have been added
        for (int counter = 0; counter < ARRAY_LENGTH; counter += 1) {

            // Add a random integer to the array, cast as an integer
            // The random integer is between 0 and 100
            arrayNum[counter] = (int) (Math.random() * (MAX_NUM + 1));
        }

        // Sort the array of numbers
        Arrays.sort(arrayNum);

        // return the sorted array of numbers
        return arrayNum;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Display instructions
        System.out.println("Welcome to the linear search program!");

        // initialize userNum outside the loop
        String userNum = "";

        // Initialize userNumInt
        int userNumInt = 0;

        // Keep looping until the user enters "q"
        do {

            // Get the sorted array by calling the populating arrays function
            int[] arrayNumber = populatingArrays();

            // Instructions
            System.out.print(
                "What number are you searching for in the list below?"
                );
            System.out.println("Enter 'q' to quit.");

            // Display the array
            for (int num : arrayNumber) {
                // Display each number, separated by a space
                System.out.print(num + " ");
            }

            // Ask the user what number they are searching for
            System.out.print("Number: ");

            // Get the user's number as a string
            userNum = scanner.nextLine();

            // If the user enters q
            if (userNum.equals("q")) {
                // Display goodbye message
                System.out.println("Goodbye!");
            } else {
                try {
                    // Convert the user's number to an integer
                    userNumInt = Integer.parseInt(userNum);

                    // Search for the user's number in the array
                    for (int index = 0; index < ARRAY_LENGTH; index += 1) {
                        // If the number is found in the array
                        if (arrayNumber[index] == userNumInt) {
                            System.out.println(
                                    "The number " + userNumInt
                                    + " is found at index " + index + "."
                                );
                            // Break out of the loop
                            break;
                        }
                        // If the number is not found in the array
                        if (index == (ARRAY_LENGTH - 1)
                                && (userNumInt != arrayNumber[index])) {
                            System.out.println(userNumInt + " is not found.");
                        }
                    }
                } catch (Exception Exception) {
                   // If the user does not enter a number
                    System.out.println(userNum + " is not an integer.");
                    System.out.println("Try again.");
                }
            }

        // Keep looping until the user enters "q"
        } while (!userNum.equals("q"));

        // Closing Scanner
        scanner.close();
    }
}
