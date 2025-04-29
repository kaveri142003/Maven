package com.jbk;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class SongDao {
	
	private Session session;
	
	Session getSession()
	{
		Configuration cfg=new Configuration().configure();
		cfg.addAnnotatedClass(Song.class);
		SessionFactory factory=cfg.buildSessionFactory();
		session=factory.openSession();
		return session;
	}
	public void saveSession(Song song)
	 {
		session=getSession();
		session.saveOrUpdate(song);
		session.beginTransaction().commit();
		System.out.println("Song inserted successfully");
	 }
	public void deleteSong(Song song)
	{
		session=getSession();
		session.delete(song);
		session.beginTransaction().commit();
		System.out.println("Song deleted successfully");
		
	}
	public void getallRecords()
	{
		session=getSession();
		Criteria criteria=session.createCriteria(Song.class);
		List<Song> ls=criteria.list();
		for (Song song : ls) {
			System.out.println(song);
		}
	}
	void showSongs()
	{
		session=getSession();
		CriteriaBuilder builder= session.getCriteriaBuilder();
		CriteriaQuery<Song> criteria= builder.createQuery(Song.class);
		Root<Song> root=criteria.from(Song.class);
		criteria.select(root);
		Query query= session. createQuery(criteria);//select from song
		List<Song> list= query.getResultList();
		for (Song song : list) {
			System.out.println(song);
		}
	}
	
	void showRecordByRestictionsAnd()
	{
		session=getSession();
		Criteria criteria = session.createCriteria(Song.class);
		criteria.add(Restrictions.eq("singer", "nishchal"));
		criteria.add(Restrictions.gt("id", 1));
		List<Song> list = criteria.list();
		for (Song song : list) {
			System.out.println(song);
		}
	}
	
	void showRecordByRestictionsOrderBy()
	{
		session=getSession();
		Criteria criteria = session.createCriteria(Song.class);
		criteria.addOrder(Order.desc("singer"));
		List<Song> list = criteria.list();
		for (Song song : list) {
			System.out.println(song);
		}
	}
	
	void showRecordByRestictionsByCriteriaBuilder(){
		session=getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Song> criteria = builder.createQuery(Song.class);
		Root<Song> root = criteria.from(Song.class);
		criteria.select(root).where(
				builder.and(
						builder.equal(root.get("singer"), "arjit")
						//builder.greaterThan(root.get("id"), 1)
						)
				);
		
		Query query =session.createQuery(criteria);
		List<Song> list = query.getResultList();
		for (Song song : list) {
			System.out.println(song);
		}
	}
	
	public void projections() {
		session= getSession();
		Criteria criteria = session.createCriteria(Song.class)
			.setProjection(Projections.projectionList()
					.add(Projections.property("name"))
					.add(Projections.property("singer"))
					);
		
		List<Object []> ls = criteria.list();
		for(Object [] row : ls) {
			System.out.println();
			System.out.println("Name of Song : " + row[0]);
			System.out.println("Name of singer : " + row[1]);
		}
	}
	
	public void projections1() {
		session= getSession();
		Criteria criteria = session.createCriteria(Song.class)
			.setProjection(Projections.property("singer"));
		
		List<String> ls = criteria.list();
		for(String row : ls) {
			System.out.println();
			System.out.println("Name of singer : " + row);
		}
	}
}
