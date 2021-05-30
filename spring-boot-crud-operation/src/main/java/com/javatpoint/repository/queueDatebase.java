package com.javatpoint.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class queueDatebase {
	 String url = "jdbc:mysql://localhost:3306/notificationtemblete";
	 
	 String user = "salsabil";
	 String password = "123";
	 Connection Con = null; 
    ResultSet RS=null;
	public queueDatebase() throws SQLException {
 	    Con = DriverManager.getConnection(url, user, password);

	}
	public abstract boolean save(String content,String method) ;
    
	
	
	
	
}
