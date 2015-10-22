package com.huasoft.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class hibernateTest extends TestCase {

	/*
	 * 保存学生
	 */
	public void testSave()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			Student student=new Student();//顺时对象
			student.setName("李四");
			student.setAge(20);
			student.setBirthDay(new Date());
			student.setTel("1254645645");
			
			session.save(student);//转换成了持久对象
			
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	/*
	 * 加载对象
	 */
	public void testLoad()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			Student student=(Student)session.load(Student.class,3);
			
			System.out.println(student.getName());
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	/*
	 * get加载
	 */
	
	public void testGet()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			Student student=(Student)session.get(Student.class,3);
			
			System.out.println(student.getName());
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/*
	 * 删除对象
	 */
	public void testDelete()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			//Student student=(Student)session.load(Student.class,1);
			
			//System.out.println(student.getName());
			
			Student student=new Student();
			student.setId(2);
			session.delete(student);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/*
	 * 更新对象
	 */
	public void testModify()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			Student student=(Student)session.load(Student.class,1);
			
			
			student.setName("admin");
			
			session.update(student);
			
			//session.saveOrUpdate(student);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/*
	 * Query 查询
	 */
	public void testQuery()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
		    Query query=session.createQuery("from Student ");
		    /*query.setFirstResult(0);
		    query.setMaxResults(10);*/
		    List<Student> list=query.list();
		    
		    for(Iterator<Student> iterator=list.iterator();iterator.hasNext();)
		    {
		    	Student student=(Student)iterator.next();
		    	System.out.println(student.getName());
		    }
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
