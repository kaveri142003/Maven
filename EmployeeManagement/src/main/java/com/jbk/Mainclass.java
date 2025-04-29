package com.jbk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println(1);
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		System.out.println(2);
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(3);
		Session session = factory.openSession();
		System.out.println(4);
		Employee emp = new Employee();
		emp = session.get(Employee.class, 6);
		System.out.println(emp);
		

	}

}
