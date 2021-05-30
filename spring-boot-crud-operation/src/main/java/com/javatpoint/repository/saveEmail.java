package com.javatpoint.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class saveEmail extends queueDatebase {

	public saveEmail() throws SQLException {
		super();
	}
	@Override
	public boolean save(String content, String mail) {
		int result=0;

		
		String query = "INSERT INTO `notifiwithmail` (`content`, `mail`)"
		        + " values ( ?, ?)";
		try {
	 PreparedStatement preparedStmt = Con.prepareStatement(query);

	 preparedStmt.setString(1,content);
	 preparedStmt.setString(2,mail);
	  
	  result=preparedStmt.executeUpdate();

	 
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(result!=0){
	   	 return true;
	   }
		
		return false;
		
	}

	
}
