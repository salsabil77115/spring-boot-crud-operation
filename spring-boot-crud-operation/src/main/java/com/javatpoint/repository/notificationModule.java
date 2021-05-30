/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.repository;


import java.util.ArrayList;

import com.javatpoint.model.Type;
import com.javatpoint.model.criteria;
import com.javatpoint.model.notificationTemplate;

/**
 *
 * @author zezo
 */

public interface notificationModule {
    
	 public boolean create(notificationTemplate x);
	 public boolean update(notificationTemplate x);
	 public boolean delete(Type type);
	 public notificationTemplate Read(Type type);
	 public ArrayList<notificationTemplate> Search(criteria x);
	 public ArrayList<notificationTemplate> readAll();
	
}
