package it.abupro.LatLng.function;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import it.abupro.LatLng.connection.*;
import it.abupro.LatLng.entities.*;

public class UserHelper {
	

	
	public UserHelper() {}
	
	/* ------------------------ SIGNIN --------------------------------*/
	/*-----------------------------------------------------------------*/
	
	//READ - controllo dato unico, parametrizzato
	// reference = colonna tabella 
	// inputToCheck il dato da confrontare con quelli già in colonna
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
	
	//READ - controllo due password uguali
	public boolean checkPassword (String psw1, String psw2) {
		boolean value;
		//(ovviamente) case sensitive
		if (psw1.equals(psw2)) {
			value=true;
		} else {
			value=false;
		}
		return value;
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
	
	
	/* ------------------------ SETTINGS -------------------------------*/
	/*-----------------------------------------------------------------*/
	
	//UPDATE - modifica parametri Utente
	// reference = colonna tabella 
	// newValue = il dato da scrivere sopra all'originale con quelli già in colonna
	//prevede un check di "autenticazione" dell'utente che deve inserire il suo usr e la sua psw
	public void updateUser(String reference, String newValue, String username, String password) {
		HibCon hUUpdateUser = new HibCon();
		try (Session s = hUUpdateUser.getSessionFactory().openSession()) {
			UserHelper uHup = new UserHelper();
			//controlla che usr/psw immesse corrispondano a usr/psw su DB 
			//vedi metodo checkUP (sopra)
			boolean check = uHup.checkUP(username, password);
			//se l'utente è "autenticato" permette di modificare il dato dentro alla colonna reference corrispondente 
			//allo username inserito dall'utente
			if (check == true) {
				Query update = s.createQuery("update Utente u set u."+reference+" = '"+newValue+"' where u.username = '"+username+"'" );
				update.executeUpdate();
			} else {
			//se l'utente non è "autenticato" stampa un errore - DA SISTEMARE PER OUTPUT SU PAGINA HTML (no syso)
				System.out.println("Username o password inseriti non sono corretti!");
			}
		}
	}

	
	
	
}
