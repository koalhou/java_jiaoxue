package com.huasoft.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.regexp.internal.recompile;

public class HibernateUtils {

	private static SessionFactory factory=null;
	
	static{
		try{
			Configuration cfg=new Configuration().configure();
			factory=cfg.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//返回sessionFactory
	public SessionFactory getSessionFactory()
	{
		return factory;
	}
	
	//获取session
	public static Session getSession()
	{
		return factory.openSession();
	}
	
	//关闭session
	public static void closeSession(Session session)
	{
		if(null!=session)
		{
			session.close();
		}
	}
	
}
