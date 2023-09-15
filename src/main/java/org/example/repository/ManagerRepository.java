package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDBClass.connect;

public class ManagerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewManager(String name, String email, String password) {
        try {
            String SQL = "INSERT INTO tbManager(name,email,password) VALUES (?,?,?)";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, password);
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String email, String password) {
        try {
            String SQL = "SELECT * FROM tbmanager WHERE email=? AND password = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, email);
            pstm.setString(2, password);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean deleteManager(String email) {
        String SQL = "DELETE FROM tbmanager WHERE email = ?";
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, email);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showAllManagers() {
        try {
            String SQL = "SELECT * FROM tbManager";
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("NOME: " + rs.getString("name"));
                System.out.println("EMAIL: " + rs.getString("email"));
                System.out.println();

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showPeoplesWithBusinessEmail() {
        try {
            String SQL = "SELECT tbSeller.name, tbSeller.email " +
                    "FROM tbSeller WHERE tbSeller.email LIKE '%zup.com.br%' " +
                    "UNION SELECT tbCustomer.name, tbCustomer.email " +
                    "FROM tbCustomer WHERE tbCustomer.email LIKE '%zup.com.br%'";

            pstm = conn.prepareStatement(SQL);
            ResultSet rset = pstm.executeQuery();

            System.out.println("\nPessoas com email que terminam com 'zup.com.br': \n");
            while (rset.next()) {
                System.out.println("\t|Pessoa:   " + rset.getString("name") + "|");
                System.out.println("\t|Email:   " + rset.getString("email") + "|");
                System.out.println();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
