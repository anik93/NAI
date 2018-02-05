package com.simpleproject.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "USER")
public class User extends BasicEntity {

	@NotNull
	@Length(min = 6, max = 255)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@NotNull
	@Column(unique = true)
	@Length(min = 1, max = 255)
	private String mail;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses = new HashSet<>();

	public User() {
		super();
	}

	public User(String name, String mail, String password, Set<Address> addresses) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.addresses = addresses;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", mail=" + mail + ", addresses=" + addresses + "]";
	}

}
