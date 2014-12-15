package com.example.shoppinglist.models;


public class Product {
	private long id;
	private String name;
	private Boolean used;
	
	public String toString() {
	    return name;
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

}
