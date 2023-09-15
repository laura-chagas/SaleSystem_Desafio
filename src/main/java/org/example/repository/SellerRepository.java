package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDBClass.connect;

public class SellerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewSeller(String name, String email, String cpf, double salary) {
        try {
            String SQL = "INSERT INTO tbSeller (name,email,cpf,salary) VALUES (?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, cpf);
            pstm.setDouble(4, salary);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String email) {
        try {
            String SQL = "SELECT * FROM tbSeller WHERE email=?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, email);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(email)) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean showSalespeopleSalary() {
        try {
            String SQL = "SELECT tbseller.name,tbseller.salary FROM tbseller ORDER BY tbseller.salary DESC;";
            pstm = conn.prepareStatement(SQL);
            ResultSet rset = pstm.executeQuery();

            System.out.println("\nSalário dos Vendedores em ordem Decrescente: \n");
            while (rset.next()) {
                System.out.println("\t|Vendedor:   " + rset.getString("name") + "|");
                System.out.println("\t|Salário:     " + rset.getDouble("salary") + "|");
                System.out.println();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSeller(int idSeller) {
        String SQL = "DELETE FROM tbseller WHERE idseller = ?";
        try {
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idSeller);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
