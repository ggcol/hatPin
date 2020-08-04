package it.abupro.LatLng.function;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import it.abupro.LatLng.connection.*;
import it.abupro.LatLng.entities.*;

public class PinHelper {
	
	
	public PinHelper() {}
	
	
	//CREATE - metodo per inserimento nuovo pin
	public void newPin(Pin l) throws ConstraintViolationException {
	HibCon hCNewPin = new HibCon();
	try (Session s = hCNewPin.getSessionFactory().openSession()) {
		s.beginTransaction();
		s.save(l);
		s.getTransaction().commit();
	}
	}
	
	
	//READ - metodo per leggere i pin e restituire una lista di singoli parametri dei pin come stringhe
	public LinkedList<String> importPinFields() {
		HibCon hLImportPinFields = new HibCon();
		try (Session s = hLImportPinFields.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			
			//legge tutta la tabella Pin e la mette in una lista di oggetti Pin
			List<Pin> read = s.createQuery("FROM Pin").getResultList();
			
			//lista di Stringhe che accoglierà i parametri dei pin come stringhe
			LinkedList<String> result = new LinkedList<String>();
		
			//Inserisce nella lista result i vari parametri necessari al costruttore .js Pin
			//sotto forma di singole Stringhe
			for (Pin p : read) {
				String latlng = p.getLatlng();
				String title = p.getTitle();
				String body = p.getBody();
				
				result.add(latlng);
				result.add(title);
				result.add(body);
				
			}
			
			//Ritorna la lista con le singole stringhe
			return result;
			
		}
	}
	
	public boolean latlngNotNull (String latlng) {
		boolean check;
		if (latlng.isBlank() || latlng.equals(null)) {
			check = false;
		} else {
			check = true;
		}
		return check;
	}
	
	/* ---------------------UPLOAD IMG-------------------
	 * ritorna inoltre come stringa il path dell'immagine
	 * che è un dato da storare su DB ------------------*/
	 
	//prende in ingresso il file in parti 
	//vedi InsertPin.java / riga 37
	public String uploadImg(Part part) {
		//descrive il path dove finirà l'immagine
		final String PATH = "C:\\Users\\ggcol\\git\\hatPin\\hatPin\\WebContent\\PinPictures\\";
		//mette in una stringa il nome del file come inserito da utente
		String nameImg = part.getSubmittedFileName();
		try{
			

		InputStream in = null;
		OutputStream out = null;

		try {
			//prende le parti inviate da http come input stream
			in = part.getInputStream();
			out = new FileOutputStream(new File(PATH+nameImg));

			//buffer!
			byte[] buffer = new byte[4096];
			int read;

			//scrive i byteletti nella destinazione di output
			while ((read = in.read(buffer)) >= 0) {
				out.write(buffer, 0, read);
			}
			} catch (FileNotFoundException e) {
				System.out.println("L'utente non ha selezionato un'immagine valida");
			} finally {
				if (out != null) {
					out.close();
				} 
				if (in != null) {
					in.close();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		String ref_img = ("PinPictures/"+nameImg);
		//ritorna percorso assoluto dove c'è immagine
		return ref_img;
	}
	
	
	//chiude classe
}
