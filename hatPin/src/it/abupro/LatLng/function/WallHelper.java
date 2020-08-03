package it.abupro.LatLng.function;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;

import it.abupro.LatLng.connection.HibCon;
import it.abupro.LatLng.entities.Pin;

public class WallHelper {
	
	public WallHelper() {}
	
	/*serve un metodo che legga entry su DB e restituisca le ultime 4 entry
	 * e di ognuna sia possibile accedere alle singole Stringhe 
	 */

	public LinkedList<String> importPin4Wall () {
		HibCon hRImportPin4Wall = new HibCon();
		try (Session s = hRImportPin4Wall.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			//mette in una lista di PIN gli ultimi 4 pin
			List<Pin> read = s.createQuery("FROM Pin order by idPin desc").setMaxResults(4).getResultList();
			
			LinkedList<String> result = new LinkedList<String>();
			String latlng;
			String title;
			String body;
			String ref_img;
			String username;
			
			//ciclando inserisce in una lista ordinata di stringhe singoli parametri di un 
			//Pin rappresentati come stringhe
			for (Pin p : read) {
				latlng = p.getLatlng();
				title = p.getTitle();
				body = p.getBody();
				ref_img = p.getRef_img();
				username = p.getUsername();
				
				result.add(latlng);
				result.add(title);
				result.add(body);
				result.add(ref_img);
				result.add(username);
				
			}
			//ritorna la lista ordinata di stringhe
			return result;
		} 
		}
	
	public LinkedList<String> importPin4Personal(String username) {
		HibCon hRImportPin4Personal = new HibCon();
		try (Session s = hRImportPin4Personal.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			//mette in una lista di Pin gli ultimi 4 pin di "username"
			List<Pin> readPers = s.createQuery("FROM Pin p where p.username = '"+username+"' order by idPin desc").setMaxResults(4).getResultList();
			
			LinkedList<String> result = new LinkedList<String>();
			String latlng;
			String title; 
			String body;
			String ref_img;
			
			for (Pin p : readPers) {
				latlng = p.getLatlng();
				title = p.getTitle();
				body = p.getBody();
				ref_img = p.getRef_img();
				
				result.add(latlng);
				result.add(title);
				result.add(body);
				result.add(ref_img);
			}
			//ritorna la lista ordinata di stringhe
			return result;
		}
	}
	
		
}
