package it.onyx.Login.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import it.onyx.Login.connection.Factory_connection;
import it.onyx.Login.dao.UserDao;
import it.onyx.Login.util.StmtCreator;

public class CrudClass {
	String firstName, lastName, num, id, email, password;
	//static Logger logger = Logger.getLogger(Factory_connection.class);
	
	
	
                           // ---------------------------------- 	READ    -------------------------------- //
	
	public UserDao selectUser (String email, String password) {
		
		Statement stmt;
		Factory_connection fc = new Factory_connection(); 
		Connection connection = fc.getConnection("videoteca", "root", "1234");
		ResultSet res = null;
		UserDao ud = new UserDao();
		
		try {
			stmt = connection.createStatement();
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1")+email+StmtCreator.getQuery("andPwd")+password+"'");
			if(res.next()) {
				ud.setNome(res.getString("nome"));
				ud.setCognome(res.getString("cognome"));
				ud.setEmail(res.getString("email"));
				ud.setId_cliente(res.getString("ID_Cliente"));
				ud.setNum_telefono(res.getString("Num_Telefono"));
				ud.setPassword(res.getString("password"));
			} else {
				throw new Exception();
			}
		} catch (SQLException e) {
			
		}catch ( Exception e) {
			//logger.debug("empty resultSet for select user query");
		}
		
		
		return ud;
	}
	
	
						// ------------------------- MAIL EXIST --------------------------- //
	
	
public Boolean emailExists ( String email ) {
		
		// verifico che la mail esista come valore salvato nel db e ritorno true per verifica durante il login
	
	    Factory_connection fc = new Factory_connection(); 
		Connection con = fc.getConnection("videoteca", "root", "1234");
		Statement stmt;
		ResultSet res = null;
		Boolean b = false;
		
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1")+email+StmtCreator.getQuery("chiudeSelect"));
			if (res.next()) return true;
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return b;
		
	}

}
