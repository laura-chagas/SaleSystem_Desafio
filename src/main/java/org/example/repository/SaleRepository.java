package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDBClass.connect;

public class SaleRepository {

    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewSale(int amount, Double total, int id_seller, int id_customer, int id_product) {
        try {
            String SQL = "INSERT INTO tbsale(amount,total,id_seller,id_customer,id_product) " +
                    "VALUES (?,?,?,?,?)";

            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, amount);
            pstm.setDouble(2, total);
            pstm.setInt(3, id_seller);
            pstm.setInt(4, id_customer);
            pstm.setInt(5, id_product);
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSale(int idSale) {
        try {
            String SQL = "DELETE FROM tbSale WHERE idsale = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idSale);
            pstm.executeUpdate();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showItemsThatHaveBeenSoldForMoreThanTen() {
        try {
            String SQL = "SELECT tbProduct.name, tbSale.total " +
                    "FROM tbProduct, tbSale " +
                    "WHERE tbSale.id_product = tbProduct.idProduct " +
                    "AND tbSale.total > 10.00 ";
            pstm = conn.prepareStatement(SQL);
            ResultSet rset = pstm.executeQuery();

            System.out.println("\nVENDAS MAIORES QUE 10 REAIS: ");
            while (rset.next()) {
                System.out.println("\t|Produto:   " + rset.getString("name") + "|");
                System.out.println("\t|Total:       " + rset.getDouble("total") + "|");
                System.out.println();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showAllSales() {
        try {
            String SQL = "SELECT * FROM tbSale";
            pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("QUANTIDADE: " + rs.getInt("amount"));
                System.out.println("TOTAL: " + rs.getString("total"));
                System.out.println("ID_VENDEDOR: " + rs.getString("id_seller"));
                System.out.println("ID_CLIENTE: " + rs.getString("id_customer"));
                System.out.println("ID_PRODUTO: " + rs.getString("id_product"));
                System.out.println();

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeTotalValueOfSalesThatAreNullToZero() {
        try {
            String SQL = "UPDATE tbSale SET total = 0 WHERE total IS NULL ";

            pstm = conn.prepareStatement(SQL);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
