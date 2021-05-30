package com.javatpoint.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sendEmail extends dequeue{

	public sendEmail() throws SQLException {
		super();

	}

	@Override
	public void send() {
		int result=0;
		ResultSet RS=null;
		PreparedStatement ps;
		PreparedStatement ps1;

		try {
			ps = Con.prepareStatement("SELECT * FROM `notifiwithmail` WHERE statue is null");

			RS=ps.executeQuery();
			int id=0;

			String email="";
			String statue="";
			while(RS.next()) {
				id=RS.getInt("id");
				email=RS.getString("mail");
				if(email.contains("@")&&email.contains(".com")) {
				statue="success";	
				}
				else {
					statue="failed";
				}
			
				ps1 = Con.prepareStatement("UPDATE notifiwithmail SET `statue`=?  where id =?");
				
			    ps1.setString(1, statue);
			    ps1.setInt(2,id);
			    ps1.executeUpdate();	
			}


			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
