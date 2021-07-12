package com.thanh.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	@NotEmpty(message = "username not empty") 
	String username;
	@NotEmpty(message = "password not empty")
	String password;
	@NotEmpty(message = "fullname not empty") 
	String fullname;
	@NotEmpty(message = "email not empty")
	@Email(message = "invalid email")
	String email;
	String photo;
	boolean admin;
	boolean activated;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
