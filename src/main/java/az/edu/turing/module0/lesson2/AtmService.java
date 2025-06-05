package az.edu.turing.module0.lesson2;

import java.util.List;
import java.util.Scanner;

public class AtmService {
    private final Scanner sc;
    private final  JDBC jdbc;

    public AtmService(JDBC jdbc, Scanner sc) {
        this.sc = sc;
        this.jdbc = jdbc;
    }
    public void checkingBalance(User user) {
        System.out.println("Cari balansiniz: "+user.getBalance()+" AZN");
    }
    public void deposit(User user) {
        System.out.println("Yatırmaq istədiyiniz məbləği daxil edin: ");
        int deposit = sc.nextInt();
        if(deposit>0){
            user.setBalance(user.getBalance()+deposit);
            jdbc.UptadeBalance(user.getId(), user.getBalance());
            jdbc.addTransaction(user.getId(), deposit,"Deposit");
            System.out.println("Məbləğ uğurla yatırıldı. Yeni balans: " + user.getBalance() + " AZN");

        }
        else {
            System.out.println("Yanlış məbləğ daxil etdiniz!");
        }
    }
    public void withdraw(User user) {
        System.out.println("Çıxarmaq istədiyiniz məbləği daxil edin: ");
        int withdraw = sc.nextInt();
        if(withdraw>0 && withdraw<user.getBalance()){

            user.setBalance(user.getBalance()-withdraw);
            jdbc.UptadeBalance(user.getId(), user.getBalance());
            jdbc.addTransaction(user.getId(), withdraw,"Withdraw");
            System.out.println("Məbləğ uğurla çıxarıldı. Yeni balans: " + user.getBalance() + " AZN");
        }
        else {
            System.out.println("Balans neqative ola bilmez");
        }
    }
    public void showTransactions(User user) {
        List<Transaction> transactions=jdbc.getTransactionsByUserId(user.getId());
        for(Transaction transaction:transactions){
            System.out.println(transaction.getType()+" "+transaction.getAmount()+" "+transaction.getTimestamp());
        }

    }

}
