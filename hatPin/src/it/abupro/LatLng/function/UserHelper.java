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
	
	//READ - controllo validità logIn
	public boolean checkUP (String email, String password) {
		HibCon hR = new HibCon();
		boolean value;
		try (Session s = hR.getSessionFactory().openSession()) {
			Object conPsw = s.createSQLQuery("SELECT password FROM User WHERE email='"+email+"';").getSingleResult();
			Object conUsr = s.createSQLQuery("SELECT email FROM User WHERE email='"+email+"';").getSingleResult();		
			String PswDB = conPsw.toString();
			String UsrDB = conUsr.toString();
			
			if (PswDB.equals(password) && UsrDB.equals(email)) {
				value=true;
			} else {
				value=false;
			}
			return value;
		}
	
	}

}
