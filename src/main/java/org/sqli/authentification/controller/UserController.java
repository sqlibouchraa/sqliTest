package org.sqli.authentification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;


@RestController
public class UserController {
	@Autowired 
	UserService userService;
	
	
	@PostMapping("/auth")
	public ResponseEntity<?> authentificationUser(@RequestParam("login") String login,@RequestParam("password") String password )
	{
	User u=	userService.authentificationUser(login, password);
	if(u!=null) {
		//u.getGroup().getUsers().size();
		if(!u.isEnabled()) {
			return ResponseEntity
					.badRequest()
					.body(new String("{ \r\n"
							+ "  \"error\": \"User disabled\"\r\n"
							+ "  }"));
		}
		else {
		return ResponseEntity.accepted()
				.body( new String("{"+
					 "\"id\" :"+ u.getId()+","+
					  "\"login\" :" + u.getLogin()+","+
					  "\"group\" :" +u.getGroup().getName()+"}"));}
	}
	else {return ResponseEntity
			.badRequest()
			.body(new String("\"error\": \"Authentication error\""));}
		
	}
	
}
