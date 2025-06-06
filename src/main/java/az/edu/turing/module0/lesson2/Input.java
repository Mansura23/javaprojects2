package az.edu.turing.module0.lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int getIntInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Zəhmət olmasa yalnız rəqəm daxil edin!");
                sc.nextLine(); // Bu, input-u təmizləyir
            }
        }
    }

    public static double getDoubleInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Zəhmət olmasa yalnız rəqəm daxil edin!");
                sc.nextLine();
            }
        }
    }

}
