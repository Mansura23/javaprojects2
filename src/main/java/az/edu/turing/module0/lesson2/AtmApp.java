package az.edu.turing.module0.lesson2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AtmApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JDBC jdbc=new JDBC();
        UserService userService = new UserService(jdbc, sc);
        AtmService atmService = new AtmService(jdbc, sc);
        User user=null;
        while(true){
            System.out.println("------ ATM Sistem ------");
            System.out.println("1. Sistəmə daxil ol");
            System.out.println("2. Qeydiyyatdan keç");
            System.out.println("0. Çıxış");
            System.out.print("Seçiminiz: ");
            int option = getIntInput(sc,"");
            sc.nextLine();
            if(option==1){
                user=userService.login();
                if(user==null){
                    break;
                }
                break;
            }
            else if(option==2){
                user = userService.register();
                if(user==null){
                    break;
                }
                break;
            }
            else if(option==0){
                System.out.println("Sistemden cixis etdiz");
                return;
            }
            else {
                System.out.println("Yanlis secim etdiz:");
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("----- ATM Sisteminə Xoş Gəldiniz -----");
            System.out.println("1. Balansa bax");
            System.out.println("2. Pul yatır");
            System.out.println("3. Pul çıxar");
            System.out.println("4. Çıxış");
            System.out.println("5.Əməliyyat tarixçəsi:");
            System.out.println("6. PIN kodunu dəyiş");
            System.out.print("Seçiminizi daxil edin: ");
            int option = getIntInput(sc,"");

            switch (option) {
                case 1:
                    atmService.checkingBalance(user);
                    break;
                case 2:
                    atmService.deposit(user);
                    break;
                case 3:
                    atmService.withdraw(user);
                    break;
                case 4:
                    running = false;
                    break;
                case 5:
                    atmService.showTransactions(user);
                    break;
                case 6:
                    userService.changePin(user);
                    break;

                default:
                    if(!sc.hasNextInt()){
                        System.out.println("Uygun reqem daxil edin: ");
                    }
                    System.out.println("Yanlis secim etmisiz");
            }

        }
        System.out.println("Cixis etdiz");
    }
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

}
