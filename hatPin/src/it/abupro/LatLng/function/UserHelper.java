package it.abupro.LatLng.function;

import org.hibernate.Session;

import it.abupro.LatLng.connection.HibCon;
import it.abupro.LatLng.entities.User;

public class UserHelper {
	
	public UserHelper() {}
	
	
	//CREATE - aggiunge nuovo Utente
	public void newUser(User u) {
		HibCon hC = new HibCon();
		try (Session s = hC.getSessionFactory().openSession()) {
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
		}
	}

}
