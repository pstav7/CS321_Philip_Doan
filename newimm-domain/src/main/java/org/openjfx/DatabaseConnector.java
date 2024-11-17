package org.openjfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection getConnection() throws SQLException {
        // Update with the correct database details
        String url = "jdbc:sqlserver://localhost:1433;databaseName=cs321;encrypt=true;trustServerCertificate=true;";
        String username = "SA";
        String password = "MyStrongPass123";

        return DriverManager.getConnection(url, username, password);
    }
}
