package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.connection.ConnectionDBClass.connect;

public class CustomerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewCustomer(String name, String email, String cpf, String address) {
        try {
            String SQL = "INSERT INTO tbCustomer (name,email,cpf,address) VALUES (?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, cpf);
            pstm.setString(4, address);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int idCustomer) {
        try {
            String SQL = "DELETE FROM tbcustomer WHERE idcustomer = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idCustomer);
            pstm.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

}