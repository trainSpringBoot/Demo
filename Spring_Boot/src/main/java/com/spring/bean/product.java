package com.spring.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "product")
public class product {
@Id
String IdProduct;
String NameProduct;
Integer Amount;
Double Price;
String Image;
String IdCategory;
}
