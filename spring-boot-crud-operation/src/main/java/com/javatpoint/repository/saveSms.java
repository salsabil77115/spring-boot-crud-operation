package com.javatpoint.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javatpoint.model.Language;
import com.javatpoint.model.Type;
import com.javatpoint.model.notificationTemplate;

public class saveSms extends queueDatebase{

	public saveSms() throws SQLException {
		super();
	}

	@Override
	public boolean save(String content, String number) {
		int result=0;

		String query = "INSERT INTO `notifiwithsms` (`content`, `number`)"
		        + " values (?, ?)";
		try {
		PreparedStatement preparedStmt = Con.prepareStatement(query);

		preparedStmt.setString(1,content);
		preparedStmt.setString(2,number);

		result=preparedStmt.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(result!=0){
			 return true;
		}
	
		return false;
  }
	public ArrayList<notificationTemplate> readAll(){
		PreparedStatement ps;
		ArrayList<notificationTemplate>templetes=new ArrayList<notificationTemplate>();
		try {
			
			ps = Con.prepareStatement("select * from templete");
			RS=ps.executeQuery();
			
			while(RS.next()) {
				notificationTemplate x=new notificationTemplate();

				x.setContent(RS.getString("content"));
				x.setLanguage(Language.getLanguage(RS.getInt("language")));
				x.setType(Type.getType(RS.getInt("type")));
				templetes.add(x);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return templetes;

		
		
	}
		
	}


