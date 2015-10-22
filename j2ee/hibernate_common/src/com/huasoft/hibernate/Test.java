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
		        //��ȡ�����ļ�
			Configuration cfg=new Configuration().configure();
			//�����Ự����
			SessionFactory factory=cfg.buildSessionFactory();
			//��ȡsession
			session=factory.openSession();
			//��������
			session.getTransaction().begin();
			
			
			Student student=new Student();
			student.setName("����");
			student.setAge(20);
			student.setBirthDay(new Date());
			student.setTel("1254645645");
			
			//�������
			session.save(student);
			//�ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			//�ع�����
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
