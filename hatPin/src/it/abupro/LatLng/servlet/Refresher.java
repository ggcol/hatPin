package it.abupro.LatLng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import it.abupro.LatLng.connection.HibCon;
import it.abupro.LatLng.entities.Pin;
import it.abupro.LatLng.function.PinHelper;

/**
 * Servlet implementation class Refresher
 */
@WebServlet("/refresher")
public class Refresher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//oggetto per estrarre dati da DB
		PinHelper pH = new PinHelper();
		//Lista che accoglie risultati estrazione (Stringhe)
		List<String> param4Marker = new LinkedList<String>();

		//Ficco nella lista singole stringhe (vedi in classe PinHelper)
		param4Marker = pH.importPinFields();

		//Ciclo la lista per estrarre le Stringhe con i singoli "parametri" che necessita
		//il costruttore .js dei Pin
		for (int i = 0; i < param4Marker.size(); i = i+3) {
			String latlng = param4Marker.get(i).toString();
			String titolo = param4Marker.get(i+1).toString();
			String corpo = param4Marker.get(i+2).toString();

			//Sempre ciclando infilo le singole stringhe con i "parametri" nel costruttore
			//.js dei Pin e lo mando alla pagina con la mappa

			/*! per ora legge e crea PIN, cose che non funzionano:
			 * - non aggiunge i pop-up
			 * - non legge il primo record su DB
			 */

			response.getOutputStream().println("<script> \nvar pinNuovo = L.marker(["+latlng+"]).addTo(myMap); \n"
					+ "pinNuovo.bindPopup('<b>"+titolo+"</b><br>"+corpo+"'); \n"
					+ "</script>");

		}
		//fuori dal ciclo


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
