package az.edu.turing.module0.lesson2;

import az.edu.turing.module0.lesson2.Config.PostgresConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    public User getUserPin(String pin) {
        String query = "select * from users where pin = ?";

        try (Connection connection=new PostgresConfig().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, pin);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pin"),
                        rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;

    }
    public  void UptadeBalance(int UserId, double Balance) {
        String query = "update users set balance = ? where id = ?";
        try(Connection connection=new PostgresConfig().getConnection();
        PreparedStatement statement=connection.prepareStatement(query)){
            statement.setDouble(1, Balance);
            statement.setInt(2, UserId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addTransaction(int userId, double amount, String type) {
        String query = "INSERT INTO transactions(user_id, amount, type) VALUES (?, ?, ?)";
        try (Connection conn = new PostgresConfig().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, type);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Transaction> getTransactionsByUserId(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE user_id = ? ORDER BY timestamp DESC";

        try (Connection conn = new PostgresConfig().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("type"),
                        rs.getTimestamp("timestamp").toLocalDateTime()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
    public boolean registerUser(String name, String pin, double balance) {
        String query = "INSERT INTO users(name, pin, balance) VALUES (?, ?, ?)";
        try(Connection connection=new PostgresConfig().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, pin);
            ps.setDouble(3, balance);
           int effectrows= ps.executeUpdate();
            return effectrows > 0;

        } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }

    }
    public  boolean changeUserPin(int userId, String newpin) {
        String query = "update users set pin = ? where id = ?";
        try(Connection connection=new PostgresConfig().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newpin);
            ps.setInt(2, userId);
            int effectrows= ps.executeUpdate();
            return effectrows > 0;

        } catch (SQLException e) {
           e.printStackTrace();
           return false;
        }
    }





}
