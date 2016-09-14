package com.kvn.entity;

import kvn.entity.ChatSession;
import kvn.entity.State;
import kvn.entity.UserProfile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="APP_USER")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;

	@Column(name="PASSWORD", nullable=false)
	private String password;

	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	@Column(name="EMAIL", nullable=false)
	private String email;

	@Column(name="STATE", nullable=false)
	private String state= State.ACTIVE.getState();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APP_USER_USER_PROFILE",
			joinColumns = { @JoinColumn(name = "USER_ID") },
			inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })

	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Set<ChatSession> chatSessions ;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Set<ChatSession> getChatSessions() {
		return chatSessions;
	}

	public void setChatSessions(Set<ChatSession> chatSessions) {
		this.chatSessions = chatSessions;
	}
}
