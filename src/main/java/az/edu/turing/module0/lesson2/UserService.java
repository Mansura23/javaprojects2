package az.edu.turing.module0.lesson2;

import java.util.Scanner;

public class UserService {
    private final JDBC jdbc;
    private final Scanner sc;

    public UserService(JDBC jdbc, Scanner sc) {
        this.jdbc = jdbc;
        this.sc = sc;
    }
    public User login() {
        System.out.println("Pin daxil edin: ");
        String pin = sc.nextLine();
        User user=jdbc.getUserPin(pin);
        if(user==null){
            System.out.println("Yanlış PIN. Yenidən cəhd edin.");
            return login();
        }
        return user;

    }
    public User register() {
        System.out.print("Adınızı daxil edin: ");
        String name = sc.nextLine();
        System.out.println("Pin daxil edin: ");
        String pin = sc.nextLine();
        if(jdbc.getUserPin(pin)!=null){
            System.out.println("Bu PIN artıq istifadə olunur. Başqa PIN seçin.");
            return null;
        }
        System.out.println("Başlanğıc balansı daxil edin: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        boolean succes= jdbc.registerUser(name,pin,balance);
        if(succes){
            System.out.println("Qeydiyyat uğurla tamamlandı!");
             return jdbc.getUserPin(pin);
        }
        else {
            System.out.println("Xeta bas verdi!");
            return null;
        }
    }
    public void changePin(User user) {
        sc.nextLine();
        System.out.println("Köhnə PIN-i daxil edin: ");
        String oldpin = sc.nextLine();
        if(!user.getPin().equals(oldpin)){
            System.out.println("Köhnə PIN səhvdir.");
            return;
        }
        System.out.println("Yeni PIN-i daxil edin: ");
        String newpin = sc.nextLine();
        if(jdbc.getUserPin(newpin)!=null){
            System.out.println("Bu pin artiq istifade olunur.Basqa pin daxil edin.");
            return;
        }
        boolean succes= jdbc.changeUserPin(user.id, newpin);
        if(succes){
            System.out.println("PIN uğurla dəyişdirildi!");
            user.setPin(newpin);
        }
        else {
            System.out.println("Xeta bas verdi!");
        }

    }
}
