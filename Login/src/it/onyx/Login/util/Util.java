package it.onyx.Login.util;

import it.onyx.Login.crud.CrudClass;
import it.onyx.Login.dao.UserDao;

public class Util {
	
	
	// --------------------- metodo login -----------------------------//
	
	
		public static UserDao login ( String email , String password) {
			
			 
			CrudClass cc = new CrudClass();
			
			UserDao ud = cc.selectUser(email, password);
			
			return ud;
			
		}
		
		
		//---------------------metodo verifica esistenza mail --------------------------//
		
		
		public static Boolean emailExist (String email) {
			
			CrudClass cc = new CrudClass();
			return cc.emailExists(email);
			
		}
		


}
