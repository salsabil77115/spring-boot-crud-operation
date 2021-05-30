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
public enum Language {
    arabic,english,notfound;

public static Language toString(String x){

switch(x){

case "arabic":  return arabic;
case "ARABIC":  return arabic;

case "english": return english;
case "ENGLISH": return english;



default: return notfound;
}

    }
public  int getMyLanguage() {
	
	switch(this){

	case arabic:  return 0;

	case english: return 1;



	default: return -1;
	}
	
}
public static Language getLanguage(int x) {
	
	switch(x){

	case 0:  return arabic;

	case 1: return english;



	default: return notfound;
	}
	
}
}