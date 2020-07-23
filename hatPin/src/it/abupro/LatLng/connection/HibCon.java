package it.abupro.LatLng.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibCon {
	
	private SessionFactory sFactory;
	
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	public SessionFactory getSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sFactory = metadata.getSessionFactoryBuilder().build();
		return sFactory;
	}
	
	/*
	 * Schema "hatpin"
	 * 
	 * Tabella pin
	 * colonne:
	 * 
	 * idPin INT PK, NN, UQ, AI
	 * latlng VARCHAR(255) NN
	 * title VARCHAR(255) 
	 * body MEDIUMTEXT
	 * ref_img VARCHAR(255) 
	 * 
	 * Tabella utente
	 * colonne:
	 * 
	 * idUtente INT PK, NN, UQ, AI
	 * username VARCHAR(255) NN, UQ
	 * name VARCHAR (255)
	 * surname VARCHAR(255)
	 * bio MEDIUMTEXT
	 * email VARCHAR(255) NN, UQ
	 * password VARCHAR (255) NN
	 * birthdate VARCHAR (45)
	 * gender VARCHAR (45)
	 */
}


