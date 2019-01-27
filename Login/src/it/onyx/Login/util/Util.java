package it.onyx.Login.util;

import javax.servlet.ServletContext;

import it.onyx.Login.crud.CrudClass;
import it.onyx.Login.dao.UserDao;

public class Util {
	
	
	// --------------------- metodo login -----------------------------//
	
	
		public static UserDao login ( String email , String password, ServletContext servletContext) {
			
			 
			CrudClass cc = new CrudClass();
			
			UserDao ud = cc.selectUser(email, password, servletContext);
			
			return ud;
			
		}
		
		
		//---------------------metodo verifica esistenza mail --------------------------//
		
		
		public static Boolean emailExist (String email, ServletContext servletContext) {
			
			CrudClass cc = new CrudClass();
			return cc.emailExists(email, servletContext);
			
		}
		
		
		// --------------------------------- metodo create ----------------------                //
		
		public static Boolean create ( UserDao ud, ServletContext servletContext) {
			
			CrudClass cc = new CrudClass();
			
			if (cc.createUser(ud, servletContext)) 
				return true;
			else return false;
			
		}
		
		


}
