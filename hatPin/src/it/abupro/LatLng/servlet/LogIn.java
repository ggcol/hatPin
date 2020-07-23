package it.abupro.LatLng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.LatLng.function.UserHelper;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserHelper uH = new UserHelper();
		
		//controlla concordanza dati immessi con tabella DB 
		//vedi UserHelper.java / LogIn / checkUP()
		boolean checkUP = uH.checkUP(request.getParameter("username"), request.getParameter("password"));
		
		if (checkUP == true)  {
		//se la concordanza username-password è verificata invia a dashboard
			response.sendRedirect("dashboard.html");
		} else {
		//se la concordanza username-password NON è verificata restituisce un errore sulla pagina
			response.getOutputStream().println("Qualcosa è andato storto, \n<b>verifica la correttezza dei dati inseriti!</b>");
		}
	
	}

}
