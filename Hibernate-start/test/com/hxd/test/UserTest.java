package com.hxd.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hxd.hibernate.bean.User;
import com.hxd.hibernate.list.Person;
import com.hxd.hibernate.list.PersonSet;

public class UserTest {

		private SessionFactory sessionFactory;
		private Session session;
		private Transaction transaction;

	@Before
	public void init(){
		sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		transaction =session.beginTransaction();
	}

	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}		
	@Test
	public void test(){
		User user =new User(25L, "zhangsan", "lisi");
		session.save(user);
	
	}
	@Test
	public void listTest(){
		Person person=new Person();
		person.setName("Tom");
		person.getHoppys().add("游泳");
		person.getHoppys().add("上网");
		session.save(person);
		
	}
	@Test
	public void setTest(){
		PersonSet personSet=new PersonSet();
		personSet.getSchools().add("小学");
		personSet.getSchools().add("中学");
		session.save(personSet);
		
	}
}
