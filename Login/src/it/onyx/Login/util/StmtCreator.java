package it.onyx.Login.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class StmtCreator {
	
	
//static Logger logger = Logger.getLogger(Factory_connection.class);
	
	
	
	public static String getQuery (String query, ServletContext servletContext) {
		
		String outQuery;
		
		Properties prop = new Properties();
		
		
		try {
			InputStream fis = servletContext.getResourceAsStream("/WEB-INF/query.properties");
			prop.load(fis);
		}catch (FileNotFoundException e){
			System.out.println("can't load input-stream");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("troubles with properties variable");
		}
		
		outQuery = prop.getProperty(query);
		
		return outQuery;
	}

	
	
	

}
