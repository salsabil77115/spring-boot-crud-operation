package com.javatpoint.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sendSms extends dequeue{

	public sendSms() throws SQLException {
		super();
	}

	@Override
	public void send() {
		
		ResultSet RS=null;
		PreparedStatement ps;
		PreparedStatement ps1;

		try {
			ps = Con.prepareStatement("SELECT * FROM `notifiwithsms` WHERE statue is null");
			RS=ps.executeQuery();
			String number="";
			String statue="";
			int id=0;
			while(RS.next()) {
			
				number=RS.getString("number");
				id=RS.getInt("id");
				if(number.charAt(0)=='0'&&number.charAt(1)=='1'&&number.length()==11) {
				statue="success";	
				}
				else {
					statue="failed";
				}
			
				ps1 = Con.prepareStatement("UPDATE notifiwithsms SET `statue`=?  where id =?");
				
			    ps1.setString(1, statue);
			    ps1.setInt(2, id);
			    ps1.executeUpdate();	
			}


			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
		
		
		
	

}
