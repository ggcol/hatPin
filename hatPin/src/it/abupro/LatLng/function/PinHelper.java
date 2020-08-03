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

import it.abupro.LatLng.connection.*;
import it.abupro.LatLng.entities.*;

public class PinHelper {
	
	
	public PinHelper() {}
	
	
	//CREATE - metodo per inserimento nuovo pin
	public void newPin(Pin l) {
	HibCon hCNewPin = new HibCon();
	try (Session s = hCNewPin.getSessionFactory().openSession()) {
		s.beginTransaction();
		s.save(l);
		s.getTransaction().commit();
	}
	}
	
	
	//READ - metodo per leggere i pin e restituire una lista di singoli parametri dei pin come stringhe
	public List<String> importPinFields() {
		HibCon hLImportPinFields = new HibCon();
		try (Session s = hLImportPinFields.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			
			//legge tutta la tabella Pin e la mette in una lista di oggetti Pin
			List<Pin> read = s.createQuery("FROM Pin").getResultList();
			
			//lista di Stringhe che accoglier� i parametri dei pin come stringhe
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
	
	/* ---------------------UPLOAD IMG-------------------
	 * ritorna inoltre come stringa il path dell'immagine
	 * che � un dato da storare su DB ------------------*/
	 
	//prende in ingresso il file in parti 
	//vedi InsertPin.java / riga 37
	public String uploadImg(Part part) {
		//indica il percorso dove finir� l'immagine
		/* sono riuscito a farlo funzionare solo con percorsi assoluti e 
		 * non relativi. Probabilmente se caricato su vero server funzionerebbe
		 * anche con percorso relativo
		 * Se volete farlo funzionare anche da voi in locale dovete cambiare
		 * qua il percorso di directory con il vostro in locale su disco
		 */
		final String PATH = "C:\\Users\\ggcol\\git\\hatPin\\hatPin\\WebContent\\PinPictures";
		//mette in una stringa il nome del file come inserito da utente
		String nameImg = part.getSubmittedFileName();
		try{
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			//prende le parti inviate da http come input stream
			in = part.getInputStream();
			//crea un nuovo file con nome uguale a quello inserito da utente nel percorso
			//identificato a riga 79
			out = new FileOutputStream(new File(PATH+"\\"+nameImg));
			
			//buffer! - serve per leggere gruppi di byte (n.b. � un array di byte)
			byte[] buffer = new byte[4096];
			int read;
			
			//scrive i byteletti nella destinazione di output
			//finch� in int read c'� qualcosa (legge dall'array di byte)
			while ((read = in.read(buffer)) >= 0) {
				//OutputStream scrive 
				out.write(buffer, 0, read);
			}
			} catch (FileNotFoundException e) {
				System.out.println("L'utente non ha selezionato un immagine valida");
			} finally {
				//finally sempre eseguita anche se non si solleva eccezione
				//chiude OutputStream
				if (out != null) {
					out.close();
				} 
				//chiude InputStream
				if (in != null) {
					in.close();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		//infila in stringa ref_img il percorso che porta fino al file appena scritto)
		String ref_img = (PATH+"\\"+nameImg);
		//ritorna percorso assoluto dove c'� immagine
		return ref_img;
	}
	
	
	//chiude classe
}
