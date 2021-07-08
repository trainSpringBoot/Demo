package com.spring.bean;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "product")
public class product implements Serializable {
	@Id
	String idproduct;
	String nameproduct;
	Integer amount;
	Double price;
	String image;
	String idcategory;
}
