package com.thanh.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {
	@NotEmpty(message = "email not empty")
	@Email(message = "invalid email")
	String from;
	@NotEmpty(message = "email not empty")
	@Email(message = "invalid email")
	String to;
	String[] cc;
	String[] bcc;
	@NotEmpty(message = "subject not empty") 
	String subject;
	@NotEmpty(message = "body not empty") 
	String body;
	String[] attachments;
	public MailInfo(String to, String subject, String body) {
		super();
		this.from = "thanhvx08062001@gmail.com";
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}

