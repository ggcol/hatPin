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
		
		//aggiungere request.getParameter vari
		u1.setUsername(request.getParameter("username"));
		u1.setName(request.getParameter("name"));
		u1.setSurname(request.getParameter("surname"));
		u1.setBirthdate(request.getParameter("birthdate"));
		u1.setEmail(request.getParameter("email"));
		u1.setPassword(request.getParameter("password"));
		u1.setGender(request.getParameter("gender"));
		
		uH.newUser(u1);
		
		response.sendRedirect("index.html");
	}

}
