package com.jbk;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HQLEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration().configure();
		cfg.addAnnotatedClass(Song.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//Select query of hibernate(HQL)
		String hql = "from Song";
		Query  query = session.createQuery(hql);
		List<Song> ls = query.list();
		for(Song song : ls) {
			System.out.println();
			System.out.print(song);
		}
		
		
		//select query to fect data by singer name
		String hql1 = "from Song where singer=:singer";
		Query query1 = session.createQuery(hql1);
		query1.setParameter("singer", "Nishchal");
		List<Song> ls1 = query1.list();
		for(Song song1 : ls1) {
			System.out.println();
			System.out.print(song1);
		}
		
		
		//update query to update singer name from id
		Transaction tx = session.beginTransaction();
		String hql2 = "update Song set singer=:name where id=:id";
		Query query2 = session.createQuery(hql2);
		query2.setParameter("name", "Shreya");
		query2.setParameter("id", 1);
		query2.executeUpdate();
		tx.commit();
		System.out.println("Data Updated Successfully!!");
	}

}
