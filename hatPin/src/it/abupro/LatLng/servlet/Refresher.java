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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresher() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PinHelper pH = new PinHelper();
		List<String> param4Marker = new LinkedList<String>();
		
		
		param4Marker = pH.leggiPin();
		
		response.setContentType("text/html");
		
		for (int i = 0; i < param4Marker.size(); i = i+3) {
			String latlng = param4Marker.get(i).toString();
			String titolo = param4Marker.get(i+1).toString();
			String corpo = param4Marker.get(i+2).toString();
		PrintWriter out = response.getWriter();
		
		//da sistemare
		out.println("<!doctype html>\r\n" + 
				"<head>\r\n" + 
				"<!-- style sheet leaflet-->\r\n" + 
				"<link rel=\"stylesheet\"\r\n" + 
				"	href=\"https://unpkg.com/leaflet@1.6.0/dist/leaflet.css\"\r\n" + 
				"	integrity=\"sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==\"\r\n" + 
				"	crossorigin=\"\" />\r\n" + 
				"\r\n" + 
				"<!-- leaflet js config -->\r\n" + 
				"<script src=\"https://unpkg.com/leaflet@1.6.0/dist/leaflet.js\"\r\n" + 
				"	integrity=\"sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew==\"\r\n" + 
				"	crossorigin=\"\"></script>\r\n" + 
				"<!-- rende non scalabile la mappa -->\r\n" + 
				"<meta name=\"viewport\"\r\n" + 
				"	content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\r\n" + 
				"\r\n" + 
				"<title>-- PROVA MAPPA --</title>\r\n" + 
				"\r\n" + 
				"<!-- stile contenitore mappa-->\r\n" + 
				"<style>\r\n" + 
				"body {\r\n" + 
				"	padding: 0;\r\n" + 
				"	margin: 120;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"html, body, #map {\r\n" + 
				"	height: 600px;\r\n" + 
				"	width: 1024px;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"	<!-- contenitore mappa -->\r\n" + 
				"	<div id=\"map\"></div>\r\n" + 
				"	\r\n" + 
				"	<form action=\"insertPin\" method=\"get\">\r\n" + 
				"		<label for=\"titolo\">Titolo: </label> <br><br> \r\n" + 
				"		<input type=\"text\" id=\"titolo\" name=\"titolo\" /><br><br> \r\n" + 
				"		<label for=\"corpo\">Cosa vuoi raccontare?</label> \r\n" + 
				"		<input type=\"text\" id=\"corpo\" name=\"corpo\" /><br><br>\r\n" + 
				"		<input type=\"hidden\" id=\"latlng\" name=\"latlng\" value=\"\" />\r\n" + 
				"		\r\n" + 
				"		\r\n" + 
				"		<fieldset>\r\n" + 
				"			<legend>Scope entry</legend>\r\n" + 
				"			Solo io <input type=\"radio\" name=\"scope\" value=\"userOnly\" /> Amici <input\r\n" + 
				"				type=\"radio\" name=\"sesso\" value=\"friendsOnly\" /> Tutti <input\r\n" + 
				"				type=\"radio\" name=\"sesso\" value=\"all\" />\r\n" + 
				"		</fieldset>\r\n" + 
				"\r\n" + 
				"		<input type=\"submit\" value=\"Submit Pin\">\r\n" + 
				"\r\n" + 
				"	</form>\r\n" + 
				"	\r\n" + 
				"	<form action=\"refresher\" method=\"get\">\r\n" + 
				"	<input type=\"submit\" value=\"Refresh\" >\r\n" + 
				"	</form>\r\n" + 
				"\r\n" + 
				"	\r\n" + 
				"	<!-- <script id=\"caricaPin\">\r\n" + 
				"</script>  -->\r\n" + 
				"\r\n" + 
				"	<!-- .setView([45.483388, 9.200729], 13) -->\r\n" + 
				"	<script>\r\n" + 
				"    var myMap = L.map('map').locate({setView: true, maxZoom: 16});\r\n" + 
				"   \r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"	<!-- + tile layer strade ESSENZIALE! -->\r\n" + 
				"	<!-- access token otenuto da mapbox.com, basta fare registrazione -->\r\n" + 
				"	<script>\r\n" + 
				"    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {\r\n" + 
				"        attribution: 'Map data &copy; <a href=\"https://www.openstreetmap.org/\">OpenStreetMap</a> contributors, <a href=\"https://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"https://www.mapbox.com/\">Mapbox</a>',\r\n" + 
				"        maxZoom: 18,\r\n" + 
				"        id: 'mapbox/streets-v11',\r\n" + 
				"        tileSize: 512,\r\n" + 
				"        zoomOffset: -1,\r\n" + 
				"        accessToken: 'pk.eyJ1IjoicmVkcm92ZXIiLCJhIjoiY2tjb3VkMnI5MG9uaTJ4bGZkcHpuZTVoaSJ9.D9NLoVyZKNt4Cai3QVQlGg'\r\n" + 
				"    }).addTo(myMap);\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"	<!-- prova interazione per add pin -->\r\n" + 
				"	<script>\r\n" + 
				"    var newMarker = L.marker();\r\n" + 
				"\r\n" + 
				"function onMapClick(e) {\r\n" + 
				"    newMarker\r\n" + 
				"        .setLatLng(e.latlng)\r\n" + 
				"        .bindPopup(\"Aggiungi un nuovo pin con l'apposito form\")\r\n" + 
				"        .addTo(myMap);\r\n" + 
				"    	document.getElementById(\"latlng\").value = e.latlng.lat+\", \"+e.latlng.lng;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"myMap.on('click', onMapClick);\r\n" + 
				"\r\n" + 
				"</script>\r\n" + 
				"<script>var pinNuovo = L.marker(["+latlng+"]).addTo(myMap); "
				+ "pinNuovo.bindPopup('<b>"+titolo+"</b><br>"+corpo+"');"
				+ "</script>" +
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
//		out.println("<script>var pinNuovo = L.marker(["+latlng+"]).addTo(myMap); "
//				+ "pinNuovo.bindPopup('<b>"+titolo+"</b><br>"+corpo+"');"
//				+ "</script>");
	
		out.println("document.getElementById(\"caricaPin\").innerHTML = \"\"\r\n");
		
		}
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
