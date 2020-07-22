package it.abupro.LatLng.function;

import it.abupro.LatLng.entities.*;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;

import it.abupro.LatLng.connection.*;

public class PinHelper {
	
	
	public PinHelper() {}
	
	
	//CREATE - metodo per inserimento nuovo pin
	public void newPin(Pin l) {
	HibCon hC = new HibCon();
	try (Session s = hC.getSessionFactory().openSession()) {
		s.beginTransaction();
		s.save(l);
		s.getTransaction().commit();
	}
	}
	
	//READ - metodo per leggere i pin e restituire una lista di singoli parametri dei pin come stringhe
	public List<String> importPinFields() {
		HibCon hL = new HibCon();
		try (Session s = hL.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			
			//legge tutta la tabella Pin e la mette in una lista di oggetti Pin
			List<Pin> read = s.createQuery("FROM Pin").getResultList();
			
			//lista di Stringhe che accoglierà i parametri dei pin come stringhe
			List<String> result = new LinkedList<String>();
		
			//Inserisce nella lista result i vari parametri necessari al costruttore .js Pin
			//sotto forma di singole Stringhe
			for (Pin item : read) {
				String latlng = item.LatLngToString();
				String title = item.TitleToString();
				String body = item.BodyToString();
				
				result.add(latlng);
				result.add(title);
				result.add(body);
				
			}
			
			//Ritorna la lista con le singole stringhe
			return result;
			
		}
	}
	
	
	

}
