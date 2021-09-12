package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//via a simple JDBC - uses simple JDBC API - DB Connection
public class ConnectionFactory {

	//fields are encapsulated within the method -> the class does not "know" them
	public static Connection getConnection() {
        
        final String USERNAME = "root";
        final String PASS = "ngin123";
        final String MYSQLURL = "jdbc:mysql://localhost:3306/crm_bank?zeroDateTimeBehavior=CONVERT_TO_NULL &"
        		+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
        		+ "serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

        //we start with an empty connection
        Connection con = null;
        
        //exception handling
        try {
          con = DriverManager.getConnection(MYSQLURL, USERNAME, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
