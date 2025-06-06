package az.edu.turing.module0.lesson2;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private double amount;
    private  String type;
    private LocalDateTime timestamp;

    public Transaction(int id, double amount, String type, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
