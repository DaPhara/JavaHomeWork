package exception;

import java.util.Scanner;

public class Handle {
    public static String getStringInput(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                System.out.println("Please enter a non-numeric value.");
                System.out.print("Try again: ");
            }
        } while (input.matches("\\d+"));
        return input;
    }
}
