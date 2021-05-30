package com.javatpoint.controller;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Notification;
import com.javatpoint.model.Type;
//mark class as Controller


@RestController
public class notificationControllerSend
{
@Autowired
Notification notifi;

//creating a get mapping that retrieves the detail of a specific notification

@PostMapping("/sendNotification/{Type}/{method}")
private boolean  sendNotification(@PathVariable("Type")Type type,@PathVariable("method") String method,@RequestBody Notification noti) throws SQLException
{
return  notifi.getData(noti,type,method) ;
}

}
