package it.abupro.LatLng.function;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.abupro.LatLng.connection.*;
import it.abupro.LatLng.entities.*;

public class UserHelper {



	public UserHelper() {}

	/* ------------------------ SIGNIN --------------------------------*/
	/*-----------------------------------------------------------------*/

	//READ - controllo dato unico, parametrizzato
	// reference = colonna tabella, inputToCheck il dato da confrontare con quelli in colonna
	// reference = colonna tabella 
	// inputToCheck il dato da confrontare con quelli già in colonna
	public boolean alredyExist (String reference, String inputToCheck) {
		HibCon hRAlredyExist = new HibCon();
		boolean value;
		try (Session s = hRAlredyExist.getSessionFactory().openSession()) 
		{
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
		//psw deve avere almeno 8 (massimo 255) caratteri di cui almeno uno deve essere 
		//un numero e uno deve essere una lettera
		boolean regex = psw1.matches("((?=.*[0-9])(?=.*[a-zA-Z]).{8,255})");
		//(ovviamente) case sensitive
		if (psw1.equals(psw2) && regex == true) {
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


	//READ - controllo validit� logIn
	public boolean checkUP (String username, String password) 
	{
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

	//	/* ------------------------ SETTINGS -------------------------------*/
	//	/*-----------------------------------------------------------------*/
	//
	//	//UPDATE - modifica parametri Utente
	//	// reference = colonna tabella 
	//	// newValue = il dato da scrivere sopra all'originale con quelli già in colonna
	//	//prevede un check di "autenticazione" dell'utente che deve inserire il suo usr e la sua psw
	//	public void updateUser(String reference, String newValue, String username, String password) {
	//		HibCon hUUpdateUser = new HibCon();
	//		try (Session s = hUUpdateUser.getSessionFactory().openSession()) {
	//			UserHelper uHup = new UserHelper();
	//			//controlla che usr/psw immesse corrispondano a usr/psw su DB 
	//			//vedi metodo checkUP (sopra)
	//			boolean check = uHup.checkUP(username, password);
	//			//se l'utente è "autenticato" permette di modificare il dato dentro alla colonna reference corrispondente 
	//			//allo username inserito dall'utente
	//			if (check == true) {
	//				Query update = s.createQuery("update Utente u set u."+reference+" = '"+newValue+"' where u.username = '"+username+"'" );
	//				update.executeUpdate();
	//			} else {
	//				//se l'utente non è "autenticato" stampa un errore - DA SISTEMARE PER OUTPUT SU PAGINA HTML (no syso)
	//				System.out.println("Username o password inseriti non sono corretti!");
	//			}
	//		}
	//	}


	//UPDATE - modifica parametri Utente
	//prende in ingresso qualsiasi cosa
	public boolean updateUser2 (String username, String name, String surname, String bio, String email, String password1, String password2, String usrChck, String pswChck) {
		//il boolean che esce dal metodo
		boolean updateOk;
		HibCon hUUpdateUser2 = new HibCon();
		UserHelper uHup = new UserHelper();
		User u = new User();
		
		boolean CUP = uHup.checkUP(usrChck, pswChck);

		try (Session s = hUUpdateUser2.getSessionFactory().openSession()) {
			
			s.beginTransaction();
			//pesca idUsr che corrisponde a username inserito
			Object conUsr = s.createSQLQuery("SELECT idUser FROM User WHERE username='"+usrChck+"';").getSingleResult();
			//lo mette in una stringa
			String UsrDB = conUsr.toString();
			//lo parsa ad int
			int idUsr = Integer.parseInt(UsrDB);
			
			//carica entit� User con id = idUsr
			u = s.load(User.class, idUsr);
			
			//se ogni parametro != null invia statement per modifica
			if (validator(username, CUP)) {
				u.setUsername(username);
			}
			if (validator(name, CUP)) {
				u.setName(name);
			}
			if (validator(surname, CUP)) {
				u.setSurname(surname);
			}
			if (validator(bio, CUP)) {
				u.setBio(bio);
			}
			if (validator(email, CUP)) {
				u.setEmail(email);
			}
			if (validator(password1, CUP)) {
				boolean checkPswPsw = uHup.checkPassword(password1, password2);
				if (checkPswPsw == true) {
					u.setPassword(password1);
				} else {
					System.out.println("Le due password non coincidono!");
				}
			}
			if (CUP == true) {
				s.getTransaction().commit();
				updateOk = true;
			} else {
				updateOk = false;
				s.getTransaction().rollback();
			}
			return updateOk;

		}
		
	}

	private boolean validator(String field, boolean CUP) {
		return field != null && !field.equals("") && CUP == true;
	}




}
