package it.abupro.LatLng.function;

import it.abupro.LatLng.entities.*;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;

import it.abupro.LatLng.connection.*;

public class PinHelper {
	
	private Pin pin;
	
	public PinHelper() {}
	
	public List<String> leggiPin() {
		HibCon hL = new HibCon();
		try (Session s = hL.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			
			//legge tutta la tabella Pin e la mette in una lista di oggetti Pin
			List<Pin> lett = s.createQuery("FROM Pin").getResultList();
			List<String> result = new LinkedList<String>();
		
			//Inserisce nella lista result i vari parametri necessari al costruttore Pin
			//sotto forma di singole Stringhe
			for (Pin item : lett) {
				String latlng = item.LatLngToString();
				String titolo = item.TitoloToString();
				String corpo = item.CorpoToString();
				
				result.add(latlng);
				result.add(titolo);
				result.add(corpo);
				
			}
			
			//Ritorna la lista con le singole stringhe
			return result;
			
		}
	}
	
	
	

}
