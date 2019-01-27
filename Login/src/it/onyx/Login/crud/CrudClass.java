package it.onyx.Login.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import it.onyx.Login.connection.Factory_connection;
import it.onyx.Login.dao.UserDao;
import it.onyx.Login.util.StmtCreator;

public class CrudClass {
	String firstName, lastName, num, id, email, password;
	//static Logger logger = Logger.getLogger(Factory_connection.class);
	
	
	
                           // ---------------------------------- 	READ    -------------------------------- //
	
	public UserDao selectUser (String email, String password, ServletContext servletContext) {
		
		Statement stmt;
		Factory_connection fc = new Factory_connection(); 
		Connection connection = fc.getConnection("videoteca", "root", "1234");
		ResultSet res = null;
		UserDao ud = new UserDao();
		
		try {
			stmt = connection.createStatement();
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1", servletContext)+email+StmtCreator.getQuery("andPwd", servletContext)+password+"'");
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
	
	
public Boolean emailExists ( String email, ServletContext servletContext ) {
		
		// verifico che la mail esista come valore salvato nel db e ritorno true per verifica durante il login
	
	    Factory_connection fc = new Factory_connection(); 
		Connection con = fc.getConnection("videoteca", "root", "1234");
		Statement stmt;
		ResultSet res = null;
		Boolean b = false;
		
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1", servletContext )+email+StmtCreator.getQuery("chiudeSelect", servletContext));
			if (res.next()) return true;
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return b;
		
	}


							// ---------------------------------- 	CREATE    -------------------------------- //


public Boolean createUser(UserDao ud, ServletContext servletContext) {
	Statement stmt;
	Factory_connection fc = new Factory_connection(); 
	Connection connection = fc.getConnection("videoteca", "root", "1234");
	ResultSet res = null;
	String id = "0";	
	Boolean ex = false;
	
	try {
		stmt = connection.createStatement();
		stmt.executeUpdate(StmtCreator.getQuery("insertCliente1", servletContext)+ud.getNome()+"','"+ud.getCognome()+"','"+ud.getNum_telefono()+"','"+id+"','"+ud.getEmail()+"','"+ud.getPassword()+StmtCreator.getQuery("chiudeInsert",servletContext));
		res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1", servletContext)+ud.getEmail()+StmtCreator.getQuery("andPwd", servletContext)+ud.getPassword()+"'");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		if(res.next()) {
			ex= true;
		} else {
			ex = false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return ex;
	
}




public ArrayList<UserDao> findAll (ServletContext servletContext){
	   
		Factory_connection fc = new Factory_connection(); 
		Connection con = fc.getConnection("videoteca", "root", "1234");
		Statement stmt;
		ResultSet res = null;
		Boolean b = false;
		
		ArrayList<UserDao> utenti = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente2", servletContext));
			
			
			while (res.next()) {
			
			String nome = res.getString("Nome");
			String cognome = res.getString("Cognome");
			String num = res.getString("Num_Telefono");
			String id = res.getString("ID_Cliente");
			String mail = res.getString("email");
			String passw = res.getString("password");
			
			UserDao ud = new UserDao();
			
			ud.setCognome(cognome);
			ud.setNome(nome);
			ud.setNum_telefono(num);
			ud.setId_cliente(id);
			ud.setEmail(mail);
			ud.setPassword(passw);
			
			utenti.add(ud);
			
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}

		
		return utenti;
		
	   
	   
}


}
