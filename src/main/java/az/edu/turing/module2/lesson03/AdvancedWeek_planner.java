package az.edu.turing.module2.lesson03;

import java.util.Scanner;

public class AdvancedWeek_planner {
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
            if (input.startsWith("change") || input.startsWith("rescdule")) {
                String[] sentence = input.split(" ", 2);
                if (sentence.length < 2) {
                    System.out.println("Invalid command. Please use 'change [day]' or 'reschedule [day].");
                    continue;
                }
                String dayinput = sentence[1];
                int dayindex = getIndex(dayinput);
                if (dayindex == -1) {
                    System.out.println("Sorry, I don't understand you, please try again");

                }
                System.out.println("Please enter new tasks ");
                String task = scanner.nextLine().trim();
                schedule[dayindex][1] = task;
                System.out.println("Task is changed succesfully.");
                continue;


            }
            int dayindex = getIndex(input);
            if (dayindex != -1) {
                System.out.println("Your task for " + schedule[dayindex][0] + " " + schedule[dayindex][1]);
            } else {
                System.out.println("You don't enter a weekday.Please try again");
            }


        }

    }

    public static int getIndex(String day) {
        String Day = day.trim().toLowerCase();
        switch (Day) {
            case "sunday":
                return 0;

            case "monday":
                return 1;

            case "tuesday":
                return 2;

            case "wednesday":
                return 3;

            case "thursday":
                return 4;

            case "friday":
                return 5;

            case "saturday":
                return 6;

            default:
                return -1;

        }

    }
}
