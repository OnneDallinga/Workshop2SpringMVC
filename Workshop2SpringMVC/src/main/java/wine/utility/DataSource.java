package wine.utility;

import java.sql.*;
import com.zaxxer.hikari.*;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    @SuppressWarnings("unused")
	private static HikariDataSource ds;
 
    static {
    		config = new HikariConfig("hikari.properties");
    		ds = new HikariDataSource( config );
    }
 
    public static Connection getConnection() throws SQLException {
    	try {
    	  	Class.forName("com.mysql.jdbc.Driver");
    	  	// Load the driver
    	  	//TODO: Figure out how to pass XML dbvars to static method
    	  	// Onne's data > u: Onne p: Once!UponAT1me
    	  	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/rsvier", "GeertL", "k44sBl0kJ3$");
    	  	// Connect to the database
    	  	return connection;
    	}
    	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return null;
    }
}