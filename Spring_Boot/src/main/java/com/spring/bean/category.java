package com.spring.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class category {
	@Id
	String idcategory;
	String namecategory;
}
