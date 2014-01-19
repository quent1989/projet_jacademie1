package org.projet1.java.models;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LiveMain {

	private static Logger logger = Logger.getLogger(LiveMain.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Collection<Chanson> listeChansons = new ArrayList<Chanson>();
		
		Chanson chanson1 = new Chanson(1, "Waka Waka", 200);
		Chanson chanson2 = new Chanson(2, "Rabiosa", 250);
		
		listeChansons.add(chanson1);
		listeChansons.add(chanson2);
		
		Album album1 = new Album(1, "Album1", listeChansons);
		Album album2 = new Album(2, "Album2", listeChansons);
		
		Artiste artiste1 = new Artiste(1, "Goldman", album1.getNomAlbum());
		Artiste artiste2 = new Artiste(2, "Shakira", album2.getNomAlbum());

		session.save(artiste1);
		session.save(artiste2);		
		
		session.save(album1);
		session.save(album2);
		
		session.save(chanson1);
		session.save(chanson2);		

		session.getTransaction().commit();
		session.close();		
		sessionFactory.close();

	}


}
