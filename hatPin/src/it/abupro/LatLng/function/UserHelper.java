package it.abupro.LatLng.function;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;

import it.abupro.LatLng.connection.*;
import it.abupro.LatLng.entities.*;

public class UserHelper {
	

	
	public UserHelper() {}
	
	/* ------------------------ SIGNIN --------------------------------*/
	/*-----------------------------------------------------------------*/
	
	//READ - controllo dato unico, parametrizzato
	// reference = colonna tabella, inputToCheck il dato da confrontare con quelli in colonna
	public boolean alredyExist (String reference, String inputToCheck) {
		HibCon hRAlredyExist = new HibCon();
		boolean value;
		try (Session s = hRAlredyExist.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			
			//SELECT E.firstName FROM Employee E - sintassi HQL con SELECT
			//legge la colonna "reference" e la mette in una lista di String
			List<String> read = s.createQuery("SELECT U."+reference+" FROM User U").getResultList();
			
			//value è TRUE se esiste già un'entry uguale!!
			value = read.contains(inputToCheck);
			return value;
			
		}
	}
	
	//CREATE - aggiunge nuovo Utente
	public void newUser(User u) {
		HibCon hCNewUser = new HibCon();
		try (Session s = hCNewUser.getSessionFactory().openSession()) {
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
		}
	}
	
	
	/* ------------------------ LOGIN ---------------------------------*/
	/*-----------------------------------------------------------------*/
	
	
	//READ - controllo validità logIn
	public boolean checkUP (String username, String password) {
		HibCon hRCheckUP = new HibCon();
		boolean value;
		try (Session s = hRCheckUP.getSessionFactory().openSession()) {
			//legge valore di password che su tabella corrisponde a username inserito
			Object conPsw = s.createSQLQuery("SELECT password FROM User WHERE username='"+username+"';").getSingleResult();
			//legge valore di username che su tabella corrisponde a username inserito
			Object conUsr = s.createSQLQuery("SELECT username FROM User WHERE username='"+username+"';").getSingleResult();		
			
			String PswDB = conPsw.toString();
			String UsrDB = conUsr.toString();
			
			
			if (PswDB.equals(password) && UsrDB.equals(username)) {
				value=true;
			} else {
				value=false;
			}
			
			//ritorna TRUE se password e username immessi corrispondono a password e username su tabella
			return value;
		}
	
	}

}
