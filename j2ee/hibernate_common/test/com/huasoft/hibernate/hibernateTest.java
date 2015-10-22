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
	 * ����ѧ��
	 */
	public void testSave()
	{
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSession();
			tx=session.getTransaction();
			tx.begin();
			
			
			Student student=new Student();//˳ʱ����
			student.setName("����");
			student.setAge(20);
			student.setBirthDay(new Date());
			student.setTel("1254645645");
			
			session.save(student);//ת�����˳־ö���
			
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	/*
	 * ���ض���
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
	 * get����
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
	 * ɾ������
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
	 * ���¶���
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
	 * Query ��ѯ
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
