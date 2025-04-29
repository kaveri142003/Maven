package com.jbk;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration().configure();
		cfg.addAnnotatedClass(Song.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//select query using create native query
		String sql = "select * from song";
		NativeQuery<Object[]> nq = session.createNativeQuery(sql);
		List<Object[]> ls = nq.list();
		for (Object[] row : ls) {
			System.out.println();
			System.out.println("Song id : " + row[0]);
			System.out.println("Song name : " + row[1]);
			System.out.println("Singer name : " + row[2]);
		}
		
		//select query using create query
		String sql1 = "from Song";
		Query<Song> nq1 = session.createQuery(sql1);
		List<Song> ls1 = nq1.list();
		for (Song song : ls1) {
			System.out.println();
			System.out.println(song);
		}
	}

}
