package com.huasoft.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
		        //读取配置文件
			Configuration cfg=new Configuration().configure();
			//创建会话工厂
			SessionFactory factory=cfg.buildSessionFactory();
			//获取session
			session=factory.openSession();
			//开启事物
			session.getTransaction().begin();
			
			
			Student student=new Student();
			student.setName("张三");
			student.setAge(20);
			student.setBirthDay(new Date());
			student.setTel("1254645645");
			
			//保存对象
			session.save(student);
			//提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			//回滚事物
			session.getTransaction().rollback();
          e.printStackTrace();
		}finally{
			if(null!=session)
			{
				session.close();
			}
		}

	}

}
