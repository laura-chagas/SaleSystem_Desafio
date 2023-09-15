package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDBClass.connect;

public class ProductRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewProduct(String name, Double price) {
        try {
            String SQL = "INSERT INTO tbProduct(name, price) VALUES (?, ?)";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(String nameProduct) {
        try {
            String SQL = "DELETE FROM tbProduct WHERE name = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, nameProduct);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showAllProducts() {
        try {
            String SQL = "SELECT * FROM tbProduct";
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("NOME: " + rs.getString("name"));
                System.out.println("PREÇO: " + rs.getDouble("price"));
                System.out.println();

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
