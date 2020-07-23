package it.abupro.LatLng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.LatLng.function.UserHelper;
import it.abupro.LatLng.entities.*;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u1 = new User();
		UserHelper uH = new UserHelper();
		
		/*------------ controllo username ------------------*/
		String usr = request.getParameter("username");
		//vedi UserHelper.java / SignIn/ alredyExist()
		boolean usrAE  = uH.alredyExist("username", usr);
		//se username non è null e non è già in utilizzo lo assegna all'utente
		if (usr != null && usrAE == false) {
			u1.setUsername(usr);
		//se username è null segnala errore
		} else if (usr == null) {
			response.getOutputStream().println("non hai inserito uno username!");
		//se username è già in uso segnala errore
		} else if (usrAE == true) {
			response.getOutputStream().println("username già in uso, prova con un altro!");
		}
		/*---------------------------------------------------*/
		
		/*------------ controllo email ------------------
		 * manca controllo indirizzo email valido ("@" e ".estensione" 
		 * decidere se farlo con js o con java */
		String email = request.getParameter("email");
		//vedi UserHelper.java / SignIn/ alredyExist()
		boolean emailAE = uH.alredyExist("email", email);
		//se email non è null e non è già in utilizzo la assegna all'utente
		if (email != null && emailAE == false) {
			u1.setEmail(email);
			//se email è null segnala errore
		} else if (email == null) {
			response.getOutputStream().println("non hai inserito un indirizzo email!");
			//se email è già in uso segnala errore
		} else if (emailAE == true) {
			response.getOutputStream().println("email già in uso, prova con un'altra!");
		}
		/*---------------------------------------------------*/
		
		/*------------ controllo password ------------------
		 * per ora controlla solo se è stata inserita una password
		 * decidere se fare check due password uguali con js o con java!
		 * */
		String password = request.getParameter("password");
		if (password != null) {
			u1.setEmail(email);
		} else {
			response.getOutputStream().println("non hai inserito una password!");
		}
		/*---------------------------------------------------*/
		
		/*------------ aggiunge tutti gli altri parametri ------------------*/
		u1.setName(request.getParameter("name"));
		u1.setSurname(request.getParameter("surname"));
		u1.setBirthdate(request.getParameter("birthdate"));
		u1.setGender(request.getParameter("gender"));
		
		//salva utente su DB 
		//vedi UtenteHelper.java / SignIn / newUser
		uH.newUser(u1);
		
		response.sendRedirect("index.html");
	}

}
