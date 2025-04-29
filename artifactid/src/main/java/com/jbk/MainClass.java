package com.jbk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		System.out.println(1);
		cfg.configure("hibernates.cfg.xml");
		cfg.addAnnotatedClass(classroom.class);
		System.out.println(2);
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(3);
		Session session = factory.openSession();
		System.out.println(4);
		
//		//get data
//		classroom cls = new classroom();
//		cls = session.get(classroom.class, 9);
//		System.out.println(cls);
		
//		//insert data
//		classroom cls1 = new classroom();
//		cls1.setClsid(102);
//		cls1.setClsname("Rushi");
//		cls1.setClscapacity(50);
//		session.save(cls1);
//		Transaction t = session.beginTransaction();
//		t.commit();
		
		classroom cls2 = new classroom(102);
		session.delete(cls2);
		Transaction t = session.beginTransaction();
		t.commit();
		

	}

}
