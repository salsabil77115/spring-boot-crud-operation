package com.javatpoint.model;
 
public class notificationTemplate {
    static int idCount=1;
 
    Type type;
    String content;
    Language language;

    public notificationTemplate() {
    }
    
    
 public notificationTemplate( Type type, String content, Language language) {
		super();
		this.type = type;
		this.content = content;
		this.language = language;

	}


public notificationTemplate(notificationTemplate x){
 
 x.content=this.content;
 x.language=this.language;
 x.type=this.type; 
 }
    
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    
    
    
    
    
    
}
