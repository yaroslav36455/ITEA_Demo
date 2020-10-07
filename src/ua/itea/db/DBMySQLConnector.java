package ua.itea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQLConnector extends DBConnector {
	
	@Override
	public Connection getConnection() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver works.");
        } catch (Exception ex) {
            // handle the error
        	ex.printStackTrace();
        }
        
		Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/humans?" +
                   	   					   "user=root&password=");

            System.out.println("Connection established");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return conn;
	}
}
