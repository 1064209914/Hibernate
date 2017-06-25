package com.hxd.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类
 * 用于
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory ;
	//ThreadLocal可以隔离多个线程的数据共享，所以不需要进行线程同步
	private static Session session ;
	
	//
	public static void getCurrentSession(){
		sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.getCurrentSession();
	}
	public  static void close(){
		sessionFactory.close();
	}
}
