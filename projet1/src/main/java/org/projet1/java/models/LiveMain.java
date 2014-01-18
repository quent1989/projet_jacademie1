package org.projet1.java.models;


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
		
		Album album1 = new Album(1, "Album1");
		Album album2 = new Album(2, "Album2");


		
		Artiste artiste1 = new Artiste(1, "Goldman", album1.getNom());
		Artiste artiste2 = new Artiste(2, "Shakira", album2.getNom());

		session.save(artiste1);
		session.save(artiste2);
		

		session.getTransaction().commit();

		session.close();
		
		sessionFactory.close();

	}


}
