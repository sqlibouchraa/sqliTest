package org.sqli.authentification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import  org.sqli.authentification.entitie.*;
import org.sqli.authentification.dao.UserDao;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User authentificationUser(String login,String password) {
	return	userDao.findByLoginAndPassword(login, password);
		
		
	}

}
