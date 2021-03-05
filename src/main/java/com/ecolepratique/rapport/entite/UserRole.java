package com.ecolepratique.rapport.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserRole implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String role;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(String login, String role) {
		super();
		this.login = login;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "user_role [login=" + login + ", role=" + role + "]";
	}
	
}
