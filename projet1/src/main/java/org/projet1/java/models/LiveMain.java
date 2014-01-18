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


		
		Artiste artiste1 = new Artiste(1, "Goldman", album1);
		Artiste artiste2 = new Artiste(2, "Shakira", album2);

		session.save(artiste1);
		session.save(artiste2);
		

		session.getTransaction().commit();

		session.close();
		
		
		
		
		/*Session session1 = sessionFactory.openSession();

		session1.beginTransaction();

		LigneCommande ligneCommande = (LigneCommande)session1.get(LigneCommande.class, 1);
		
		ligneCommande.setQuantite(2);
		
		
		session1.getTransaction().commit();

		session1.close();*/
		
		

		/*Session session = sessionFactory.openSession();

		session.beginTransaction();

		LigneCommande objet1 = new LigneCommande(10, "livre1");
		LigneCommande objet2 = new LigneCommande(5, "disque1");

		Commande c = new Commande();
		c.setDate(new Date());
		c.addLigne(objet1);
		c.addLigne(objet2);
		
		session.save(c);
		

		session.getTransaction().commit();

		session.close();*/
		
		
		/*
		
		Particulier p = new Particulier();
		p.setNom("Bigal");
		p.setPrenom("Quentin");
		
		Entreprise e = new Entreprise();
		e.setSiret("Societe des plots");
		session.save(e);

		LigneCommande objet1 = new LigneCommande(10, "livre1");
		LigneCommande objet2 = new LigneCommande(5, "disque1");

		
		Commande c = new Commande();
		c.setDate(new Date());
		c.addLigne(objet1);
		c.addLigne(objet2);
		c.setClient(p);

		
		session.save(p);*/
		
		
		//Query hqlQuery = session.createQuery("FROM Entreprise ent where ent.siret LIKE :siret");
		
		//Query hqlQuery = session.getNamedQuery("commandesForProduit");
		
		//hqlQuery.setString("labelProduit", "Livre%");
		
		/*Criteria criteria = session.createCriteria(Entreprise.class);
		
		criteria.add(Restrictions.ilike("siret", "a%"));
		
		List<Entreprise> hqlQueryResult = criteria.list();
		
		for (Entreprise entreprise : hqlQueryResult) {
			
			System.out.println("Criteria found : " + entreprise.toString());
			
			entreprise.setSiret("A-" + entreprise.getSiret());
			
		}*/
		

		
		sessionFactory.close();

	}


}
