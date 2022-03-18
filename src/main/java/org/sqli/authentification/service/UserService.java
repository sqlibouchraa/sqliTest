package org.sqli.authentification.service;

import  org.sqli.authentification.entitie.*;

public interface UserService {
	
	User authentificationUser(String login,String password);
}
