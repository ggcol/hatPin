package it.abupro.LatLng.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.Session;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	private int idUser;
	@Column(name="username")
	private String username;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="bio")
	private String bio;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	public User (int idUser, String username, String name, String surname, String bio, String email, String password) {
		setIdUser(idUser);
		setUsername(username);
		setName(name);
		setSurname(surname);
		setBio(bio);
		setEmail(email);
		setPassword(password);
	}
	
	public User () {}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
