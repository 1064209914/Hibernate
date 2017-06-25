package com.hxd.hibernate.list;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity @Table
public class Person {
	//设主键 自增长
		@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		//list集合属性
		
		@ElementCollection 
		@CollectionTable(name="hoppys",joinColumns=@JoinColumn(name="id",nullable=false))
		@OrderColumn(name="list_hoppy")
		//必须先new 不然会报 空指针异常
		private List<String> hoppys=new ArrayList<String>(); // 爱好
		
		public Person() {
		}

		public Person(String name, List<String> hoppy) {
			super();
			this.name = name;
			this.hoppys = hoppy;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", hoppy=" + hoppys+ "]";
		}
		
}
