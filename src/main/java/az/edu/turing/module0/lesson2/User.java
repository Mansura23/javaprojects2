package az.edu.turing.module0.lesson2;

public class User {
    public int id;
    private String name;
    private String pin;
    private double balance;

    public User(int id, String name, String pin, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
