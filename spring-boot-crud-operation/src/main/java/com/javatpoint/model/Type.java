/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.model;


/**
 *
 * @author zezo
 */
public enum Type {
    
    
    confirmation,booking,forgetpassword,notfound;

public static Type toString(String x){

switch(x){

case "confirmation":  return confirmation;
case "CONFIRMATION":  return confirmation;

case "booking": return booking;
case "BOOKING": return booking;

case "forgetpassword": return forgetpassword;
case "FORGETPASSWORD": return forgetpassword;

default: return notfound;
}


    }
public  int getMyType() {
	
	switch(this){

	case confirmation:  return 0;

	case booking: return 1;


	case forgetpassword: return 2;


	default: return -1;
	}
	
}
public static Type getType(int x) {
	
	switch(x){

	case 0:  return confirmation;

	case 1: return booking;

	case 2:return forgetpassword;

	default: return notfound;
	}
	
}
    
    
}
