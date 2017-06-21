package com.hxd.hibernate.bean;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {

	private Long id;
	private String name;
	private String pass;
	public User(){
	}
	public User(Long id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
}
