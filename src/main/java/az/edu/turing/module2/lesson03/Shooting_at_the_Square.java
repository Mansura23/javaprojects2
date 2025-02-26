package az.edu.turing.module2.lesson03;

import java.util.Random;
import java.util.Scanner;

public class Shooting_at_the_Square {
    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[][] arr = CreateArr();
        int targetrow = random.nextInt(5)+1;
        int targetcol = random.nextInt(5)+1;



        while (true) {
            DisplayArr(arr);
            int row = isNumber(scanner, "Enter the row to shoot (1-5): ") - 1;
            int col = isNumber(scanner, "Enter the col to shoot (1-5): ") - 1;
            if (row == targetrow && col == targetcol) {
                arr[row][col] = 'X';
                System.out.println("You have won");
                DisplayArr(arr);
                break;

            } else {
                arr[row][col] = '*';

            }

        }


    }


    public static char[][] CreateArr() {
        char[][] arr = new char[5][5];
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '-';

            }

        }
        return arr;


    }

    public static int isNumber(Scanner scanner, String prompt) {


        boolean isnumber = false;
        int number = 0;
        while (!isnumber) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number > 5 || number <= 0) {
                    System.out.println("Please enter a number between 0 and 5");
                    continue;
                }
                isnumber = true;
            } else {
                System.out.println("You have entered an invalid number.Please try again :");
                scanner.nextLine();
            }

        }
        return number;

    }

    public static void DisplayArr(char[][] arr) {
        System.out.print("");
        for (int i = 0; i <= arr[0].length; i++) {
            System.out.print(i + " | ");

        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i+1) + " | ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");

            }
            System.out.println();

        }
        System.out.println();
    }

    //
    //
    //
    //        # Arrays
    //
    //# The task is as follows
    //
    //Write a program called "shooting at the square."
    //
    //#### Technical requirements:
    //
    //- Given a 5x5 square, where the program randomly sets a target.
    //- Before the game starts, the text is displayed on the screen: All set. Get ready to rumble!
    //- The whole process of the game is processed in an infinite loop.
    //- The player is asked to enter a line for fire; the program checks that the user enter is a number, and this entered
    //  number is in the range of playing field lines (1-5). As long as the player makes mistakes, he will be asked to enter
    //  the number again.
    //- The player is asked to enter a shooting bar (must pass the same check).
    //- After each shot, the updated game field should be displayed in the console. Cells, where the player has already shot
    //  is necessary to note as `* `.
    //- The game ends when the target is defeated. At the end of the game, display the phrase in console: `You have won!`. The
    //  target should be marked as `x `.
    //- The task must be done using arrays (**DO NOT USE THE INTERFACES** `List`, `Set`, `Map`).
    //
    //An example of console output:
    //
    // 0 | 1 | 2 | 3 | 4 | 5 |
    // 1 | - | - | - | - | - |
    // 2 | - | * | * | - | - |
    // 3 | * | - | - | * | - |
    // 4 | - | - | - | - | * |
    // 5 | * | - | * | - | - |}
    //    }


}