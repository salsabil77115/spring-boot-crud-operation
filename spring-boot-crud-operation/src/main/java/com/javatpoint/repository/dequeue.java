package com.javatpoint.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class dequeue {

	 String url = "jdbc:mysql://localhost:3306/notificationtemblete";
	 
	 String user = "salsabil";
	 String password = "123";
	 Connection Con = null; 
   ResultSet RS=null;
	
	public dequeue() throws SQLException {
 	    Con = DriverManager.getConnection(url, user, password);


	}

	public abstract void send();
}
