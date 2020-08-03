package it.abupro.LatLng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.LatLng.function.UserHelper;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/logIn")
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
			response.sendRedirect("dashboardhatpin.jsp");
		} else {
		//se la concordanza username-password NON è verificata restituisce un errore sulla pagina
			//bisogna aggiungere ${errore_login} nella pagina
			request.setAttribute("errore_login", "Qualcosa e' andato storto,<br>verifica la correttezza dei dati<br>inseriti!");
			request.getRequestDispatcher("/login.jsp").include(request, response);
			
		}
	
	}

}
