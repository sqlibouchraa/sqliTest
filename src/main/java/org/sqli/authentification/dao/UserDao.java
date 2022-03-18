package org.sqli.authentification.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  org.sqli.authentification.entitie.*;

@Repository
public interface UserDao  extends JpaRepository<User, Integer>{
	
	User findByLoginAndPassword(String login,String password);
	List<User> findByLogin(String login);

}
