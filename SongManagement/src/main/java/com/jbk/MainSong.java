package com.jbk;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SongDao dao=new SongDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Add Song");
		System.out.println("3. Delete Song");
		System.out.println("3. Show all Songs");
		System.out.println("4. Show Record of Arjit and id > 1 by Criteria Method");
		System.out.println("5. Show all songs by Singer name in descending order");
		System.out.println("6. Show Record of Arjit and id > 1 by criteriaBuilder Method");
		System.out.println("7. Show all records of Singer name & Song name by Projections");
		System.out.println("7. Show all records of Singer name by Projections");
		System.out.println("Enter a choice :");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:System.out.println("Enter a song & Artist");
		Song song=new Song(sc.next(), sc.next());
			dao.saveSession(song);
			break;
		
		case 2:System.out.println("Enter a id");
		Song songdelete=new Song(sc.nextInt());
			dao.deleteSong(songdelete);
			break;
			
		case 3:
			dao.showSongs();
			break;
		
		case 4:
			dao.showRecordByRestictionsAnd();
			break;
		
		case 5: 
			dao.showRecordByRestictionsOrderBy();
			break;
		
		case 6 : 
			dao.showRecordByRestictionsByCriteriaBuilder();
			break;
		
		case 7 : 
			dao.projections();
			break;
		case 8 : 
			dao.projections1();
			break;
		}	
	}
	}


