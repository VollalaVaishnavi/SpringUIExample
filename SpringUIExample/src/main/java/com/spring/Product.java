package com.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity //specifies class is an entity and is mapped to database table
public class Product {
@Id //acts as primary key
@GeneratedValue(strategy=GenerationType.AUTO)
public int id;
@NotNull(message="name should not be empty")
@Size(min=2,max=10)  
public String name;
@NotEmpty(message="Brand should not be empty") 
public String brand;
@NotEmpty(message="Launch should not be empty")
public String madein;
@NotNull
@Range(min=1000, max=100000)
public float price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getMadein() {
	return madein;
}
public void setMadein(String madein) {
	this.madein = madein;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Product(int id, String name, String brand, String madein, float price) {
	super();
	this.id = id;
	this.name = name;
	this.brand = brand;
	this.madein = madein;
	this.price = price;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
			+ "]";
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}

}
