package org.sqli.authentification.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private boolean enabled;
	@Column(name="LOGINATTEMPTS")
	private int loginAttempts;
	 //@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="GROUP_ID")
	private Group group;
	 
	 
	 
	public User() {}
	
	public User(String login, String password, boolean enabled, int loginAttempts, Group group) {
		super();
		this.login = login;
		this.password = password;
		this.enabled = enabled;
		this.loginAttempts = loginAttempts;
		this.group = group;
	}
	

	public User(int id, String login, String password, boolean enabled, int loginAttempts, Group group) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.enabled = enabled;
		this.loginAttempts = loginAttempts;
		this.group = group;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	 

}
