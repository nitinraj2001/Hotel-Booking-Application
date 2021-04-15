package com.nitinraj.hotelbooking.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private UserProfile userprofile;

	public Users() {
		super();
		
	}

	public Users(int id, String username, String email, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public UserProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", enabled=" + enabled + ", userprofile=" + userprofile + "]";
	}

	

	             
	

}
