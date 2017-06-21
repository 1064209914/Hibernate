package com.hxd.hibernate.bean;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserTest {
		private static final Logger logger=Logger.getLogger(UserTest.class);
		private Session session=null;
		private SessionFactory sessionFactory=null;
		
		public Session getSession(){
			sessionFactory=new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			return session;
		}
	
		public void closeSession(){
			if (session!=null) {
				session.close();
			}
			if (sessionFactory!=null) {
				sessionFactory.close();
			}
		}
		
		
		//插入数据
		public Long insert(User user) {
			session=getSession();
			Transaction transaction=  session.beginTransaction();// 开始事物
			long id=(long) session.save(user);//保存表
			transaction.commit();
			closeSession();
			return id;
		}
		
		//更新数据
		public  void update( User user ){
			session=getSession();
			Transaction transaction=session.beginTransaction();
			session.update(user);
			transaction.commit();
			closeSession();
 		}
		
		//删除数据
		public void delete(User user){
			session=getSession();
			Transaction transaction=  session.beginTransaction();// 开始事物
			session.delete(user);
			transaction.commit();
			closeSession();
		}
		
		//获取一条数据
		public User getUserById( Long id ){
			session=getSession();
			User user=session.get(User.class, id);
			closeSession();
			return user;
		}
		
		//获取列表
		@SuppressWarnings("unchecked")
		public List<User> getUserList(){
			session=getSession();
			List<User> userlist=session.createQuery("from User").getResultList();
		closeSession();
		return userlist;
		}
		
		
	public static void main(String[] args) {
			UserTest userTest=new UserTest();
			User user=new User();
			user.setId(6L);
			List<User> userlist=userTest.getUserList();
			for (User user2 : userlist) {
				logger.info(user2);
			}

	}

}
