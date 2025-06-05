package az.edu.turing.module1.lesson03;

import java.util.Scanner;

public class Week_planner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[][] schedule = {
                {"Sunday", "do homework"},
                {"Monday", "go to courses; watch a film"},
                {"Tuesday", "attend meetings; read a book"},
                {"Wednesday", "workout; complete assignments"},
                {"Thursday", "practice coding; cook dinner"},
                {"Friday", "go out with friends; relax"},
                {"Saturday", "family time; clean the house"}
        };

        while (true) {
            System.out.println("Please, input the day of the week: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) {
                break;
            }

            switch (input) {
                case "sunday":
                    System.out.println("Your tasks for " + " Sunday  are " + schedule[0][1]);
                    break;
                case "monday":
                    System.out.println("Your tasks for " + " Monday  are " + schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println("Your tasks for " + " Tuesday  are " + schedule[2][1]);
                    break;
                case "wednesday":
                    System.out.println("Your tasks for " + " Wednesday  are " + schedule[3][1]);
                    break;
                case "thursday":
                    System.out.println("Your tasks for " + " Thursday are " + schedule[4][1]);
                    break;
                case "friday":
                    System.out.println("Your tasks for " + " Friday are " + schedule[5][1]);
                    break;
                case "saturday":
                    System.out.println("Your tasks for " + " Saturday are  " + schedule[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again ");
                    continue;
            }
        }


    }
}
