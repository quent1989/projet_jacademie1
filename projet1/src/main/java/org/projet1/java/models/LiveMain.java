package org.projet1.java.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projet1.java.reader.ReadFile;


public class LiveMain {

	private static Logger logger = Logger.getLogger(LiveMain.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		logger.info("Debut test de la BDD");
		Collection<Chanson> listeChansons = new ArrayList<Chanson>();

		Album album1 = new Album(1, "Album1", listeChansons);
		Album album2 = new Album(2, "Album2", listeChansons);
		
		Chanson chanson1 = new Chanson(1, "Waka Waka", 200, album1.getNomAlbum());
		Chanson chanson2 = new Chanson(2, "Rabiosa", 250, album2.getNomAlbum());
	
		listeChansons.add(chanson1);
		listeChansons.add(chanson2);
		
		album1.setListeChansons(listeChansons);
		album2.setListeChansons(listeChansons);

		Artiste artiste1 = new Artiste(1, "Goldman", album1.getNomAlbum());
		Artiste artiste2 = new Artiste(2, "Shakira", album2.getNomAlbum());

		session.save(artiste1);
		session.save(artiste2);
		
		session.save(album1);
		session.save(album2);
		
		session.save(chanson1);
		session.save(chanson2);
		logger.info("fin tests de la BDD");
		
		
		logger.info("Lecture fichiers .music et alimentation de la BDD");
		Collection<Artiste> artistes = new ArrayList<Artiste>();
		Collection<Album> albums = new ArrayList<Album>();
		Collection<Chanson> chansons = new ArrayList<Chanson>();
		
		ReadFile.FileReader(artistes, albums, chansons);
		
		logger.info("Ajout des artistes à la BDD");
		for (Artiste artiste : artistes) {
			session.save(artiste);
		}
		
		logger.info("Ajout des albums à la BDD");
		for (Album album : albums) {
			session.save(album);
		}
		
		logger.info("Ajout des chansons à la BDD");
		for (Chanson chanson : chansons) {
			session.save(chanson);
		}

		session.getTransaction().commit();
		
		
		logger.info("Préparation des requetes SQL");
		Query hqlQuery1 = session.createQuery("FROM Album");		
		Query hqlQuery2 = session.createQuery("FROM Artiste");
		Query hqlQuery3 = session.createQuery("FROM Chanson");

		logger.info("Récupération des données Album de la BDD");
		List<Album> listAlbum = hqlQuery1.list();
		
		logger.info("Albums dans la BDD :");
		for (Album album : listAlbum) {
			logger.info(album.toString());			
		}
		
		logger.info("Récupération des données Artistes de la BDD");
		List<Artiste> listArtiste = hqlQuery2.list();
		
		logger.info("Artistes dans la BDD :");
		for (Artiste artiste : listArtiste) {
			logger.info(artiste.toString());
		} 
		
		logger.info("Récupération des données Chanson de la BDD");
		List<Chanson> listChanson = hqlQuery3.list();
		
		logger.info("Chansons dans la BDD :");		
		for (Chanson chanson : listChanson) {
			logger.info(chanson.toString());
		}
		

		session.close();		
		sessionFactory.close();
		
	}

}
