package az.edu.turing.module2.lesson02;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let the game begin!");
        System.out.println("Enter your name: ");

        String name = scanner.nextLine();

        int randomNumber = random.nextInt(101);
        int number = isNumber();
        boolean isGuessed = checkNumber(number, randomNumber, name);
        int[] numbers = new int[100];

        numbers[0] = number;
        int index = 1;

        while (!isGuessed) {
            number = isNumber();
            isGuessed = checkNumber(number, randomNumber, name);
            numbers[index] = number ;
            index++;
        }

        int n = numbers.length;

        for (int i = 1; i < n; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] < key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }

        System.out.print("Your Numbers: ");

        for (int j=0 ; j<index ;j++) {
            System.out.print(numbers[j] + " ");
        }

    }

    public static int isNumber() {

        Scanner scanner = new Scanner(System.in);

        int number = 0;
        boolean isNumber = false;

        while (!isNumber) {
            System.out.println("Enter your number: ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number > 100 || number < 0) {
                    System.out.println("You entered a number that is not in the range from 0 to 100. Try again.");
                    continue;
                }
                isNumber = true;

            } else {
                System.out.println("You entered not a number. Try again.");
                scanner.nextLine();
            }
        }
        return number;
    }

    public static boolean checkNumber(int number, int randomNumber, String name) {

        if (number == randomNumber) {
            System.out.println("Congratulations, " + name + "!");
            return true;

        } else if (number > randomNumber) {
            System.out.println("Your number is greater than the guessed number. Try again.");

        } else {
            System.out.println("Your number is less than the guessed number. Try again.");

        }
        return false;
    }

}