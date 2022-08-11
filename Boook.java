package com.BooksStore.cache.Redis5springbootBooksStorecrudopexamples.model;

import java.io.Serializable;

public class Boook implements Serializable {

	private String id;
	private String bname;
	private String bauthor;
	private int price;
	
	//constructor to initialize objects
	//can be used to set initial values for object attributes
	public Boook(String id, String bname, String bauthor, int price) {
		super();
		this.id = id;
		this.bname = bname;
		this.bauthor = bauthor;
		this.price = price;
	}
	
	//a getter method returns value
	public String getId() {
		return id;
	}
	
	//a setter method sets or updates value
	public void setId(String id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
