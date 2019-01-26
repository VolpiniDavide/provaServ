package it.onyx.Login.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory_connection {

	
//static Logger logger = Logger.getLogger(Factory_connection.class);

	
	Connection connection = null;
	
	public Connection getConnection (String db_name, String username, String password) { 
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+username+"&password="+password+"&serverTimezone=UTC");
	
	}catch ( Exception e) {
		//logger.debug("can't connect");
	}
	
	return connection;
	
	}
	
	
}
