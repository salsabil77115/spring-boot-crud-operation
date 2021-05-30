package com.javatpoint.model;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.javatpoint.repository.NotificationDataBase;
import com.javatpoint.repository.queueDatebase;
import com.javatpoint.repository.saveEmail;
import com.javatpoint.repository.saveSms;
@Repository
public class Notification {
	
	String[] replacment;
	String method;
	NotificationDataBase myData;  
	queueDatebase export;	
	public Notification(){
		
	}

	public String[] getReplacment() {
		return replacment;
	}

	public void setReplacment(String[] replacment) {
		this.replacment = replacment;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String mail) {
		this.method = mail;
	}

	
	
public  String replace(String[] replace ,String content){
     
		 for(int j=0;j<replace.length;j++){
		     for(int i=0;i<content.length();i++){
		         
		    if(content.charAt(i)=='*'){
		    	content=content.substring(0, i)+replace[j]+content.substring(i+1, content.length());
		     break;
		  }
		  }
		     
		 }

return  content;
 }
	

public boolean getData(Notification y ,Type x,String method) throws SQLException{
	
	String content=null;
 queueDatebase channel = null;
	
		try {
			myData = new NotificationDataBase();
	
		
		} catch (SQLException e) {
		}
		 content=myData.Read(x).getContent();

	content= this.replace(y.replacment, content);
	
	
if(method.equals("email")) {
	 channel=new saveEmail();

}

if(method.equals("sms")) {
 channel=new saveSms();
}

return help(channel,content,y.method);

}

public boolean help(queueDatebase x,String content,String method) {
	return x.save(content, method);
	
}


}



