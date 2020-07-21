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
	 * Schema hatpin
	 * 
	 * Tabella pin
	 * colonne:
	 * 
	 * idPin
	 * latlng
	 * titolo
	 * corpo
	 * ref_img
	 * 
	 * Tabella utente
	 * colonne:
	 * 
	 * idUtente
	 * username
	 * nome
	 * cognome
	 * bio
	 * email
	 * password
	 */
}


