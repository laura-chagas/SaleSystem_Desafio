package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBClass {

    private static final String url = "jdbc:postgresql://localhost:5432/dbSaleSystem";
    private static final String user = "postgres";
    private static final String password = "7399";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
