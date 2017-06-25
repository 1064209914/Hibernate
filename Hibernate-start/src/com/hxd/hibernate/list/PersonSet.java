package com.hxd.hibernate.list;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
@Table(name="person_set")
@Setter @Getter
public class PersonSet
{
	@Id @Column(name="perosn_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// 标识属性
	private Integer id;
	private String name;
	private int age;
	// 集合属性，保留该对象关联的学校
	@ElementCollection(targetClass=String.class)
	// 映射保存集合属性的表
	@CollectionTable(name="school_inf", // 指定表名为school_inf
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	// 指定保存集合元素的列为 school_name
	@Column(name="school_name",nullable=false)
	// 映射集合元素索引的列
	private Set<String > schools
		= new HashSet<>();
	public PersonSet() {
	}
	public PersonSet(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}