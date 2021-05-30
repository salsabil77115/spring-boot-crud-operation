package com.javatpoint.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javatpoint.model.Language;
import com.javatpoint.model.Type;
import com.javatpoint.model.criteria;
//repository that extends CrudRepository
import com.javatpoint.model.notificationTemplate;


@Repository
public class NotificationDataBase implements notificationModule
{
	 String url = "jdbc:mysql://localhost:3306/notificationtemblete"; 
	 String user = "salsabil";
	 String password = "123";
	 Connection Con = null; 
     ResultSet RS=null;
	
     public NotificationDataBase() throws SQLException {
	
    Con = DriverManager.getConnection(url, user, password);

	}
     
    
     
	@Override
	public boolean create(notificationTemplate x)   {
	
		int result=0;
		String query = "INSERT INTO `templete` ( `type`, `content`, `language`)"
    	        + " values ( ?, ?, ?)";
		try {
     PreparedStatement preparedStmt = Con.prepareStatement(query);

     preparedStmt.setInt(1, x.getType().getMyType());
     preparedStmt.setString(2, x.getContent());
     preparedStmt.setInt(3, x.getLanguage().getMyLanguage());


     result=preparedStmt.executeUpdate();
  
     
		} catch (SQLException e) {

			e.printStackTrace();
		}
		   if(result!=0){
		    	 return true;
		    }
		     else{

		return false;     }   

	}

	
	@Override
	public boolean update(notificationTemplate x) {
		int result=0;
		PreparedStatement ps;
		try {
			ps = Con.prepareStatement("UPDATE `templete` SET `content`=?,`language`=? where `type`=?");
	
		    ps.setString(1, x.getContent());
		    ps.setInt(2, x.getLanguage().getMyLanguage());
		    ps.setInt(3, x.getType().getMyType());

			ps.executeUpdate();	
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		   if(result!=0){
		    	 return true;
		    }
		     else{

		return false;     
		}	    	
	}

	@Override
	public boolean delete(Type type) {
int result=0;

		
PreparedStatement ps;
try {
	ps = Con.prepareStatement("DELETE FROM templete WHERE type = ?");

	ps.setInt(1,type.getMyType());
	result=ps.executeUpdate();
}
catch (SQLException e) {
	e.printStackTrace();
}
   if(result!=0){
		    	 return true;
		    }
		     else{

		return false;     }
	}

	
	
	@Override
	public notificationTemplate Read(Type type) {
		PreparedStatement ps;
		notificationTemplate x=new notificationTemplate();
		try {
			
			ps = Con.prepareStatement("select * from templete where type=?");
			ps.setInt(1, type.getMyType());
			RS=ps.executeQuery();
			
			if(RS.next()) {
				x.setContent(RS.getString("content"));
				x.setLanguage(Language.getLanguage(RS.getInt("language")));
				x.setType(Type.getType(RS.getInt("type")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;

		
	}

	@Override
	public ArrayList<notificationTemplate> Search(criteria search) {
		
		ArrayList<notificationTemplate> myList = new ArrayList<notificationTemplate>();
		PreparedStatement ps;

		if(search.equals(criteria.arabic)) {
			
			try {
				ps = Con.prepareStatement("select * from templete where language=0 ");
				RS=ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		
		else if(search.equals(criteria.english)){
			
			try {
				ps = Con.prepareStatement("select * from templete where language=1 ");
				RS=ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		else if(search.equals(criteria.confirmation)){
			
			try {
				ps = Con.prepareStatement("select * from templete where type=0 ");
				RS=ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
		else if(search.equals(criteria.booking)){
			
			try {
				ps = Con.prepareStatement("select * from templete where type=1 ");
				RS=ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		
		else if(search.equals(criteria.forgetpassword)){
			
			try {
				ps = Con.prepareStatement("select * from templete where type=2");
				RS=ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		}
		

try {
			
		   while(RS.next()) {
		notificationTemplate temp= new notificationTemplate();
			   temp.setContent(RS.getString("content"));
			   temp.setLanguage(Language.getLanguage(RS.getInt("language")));
			   temp.setType(Type.getType(RS.getInt("type")));
	
			   myList.add(temp);
			   
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	

   return myList;
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
