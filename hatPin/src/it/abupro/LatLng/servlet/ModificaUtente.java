package it.abupro.LatLng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.LatLng.function.UserHelper;

/**
 * Servlet implementation class ModificaUtente
 */
@WebServlet("/modificaUtente")
public class ModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//prende tutto
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String bio = request.getParameter("bio");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String usrChck = request.getParameter("usrChck");
		String pswChck = request.getParameter("pswChck");
		
		UserHelper uH = new UserHelper();
		
		//controlla quali campi si vogliono modificare, se utente si autentica
		//vedi UserHelper.java / Settings / updateUser2()
		boolean commit = uH.updateUser2(username, name, surname, bio, email, password1, password2, usrChck, pswChck);
		
		
		if (commit == true) {
			//se modifiche a buon fine invia msg alla pagina
			//aggiungere ${update_profile_ok}
			request.setAttribute("update_profile_ok", "Modifica andata a buon fine!");
			request.getRequestDispatcher("/modificautente.jsp").include(request, response);
		} else {
			//se modifiche non a buon fine invia msg alla pagina
			//aggiungere ${update_profile_not_ok"
			request.setAttribute("update_profile_not_ok", "Le modifiche non sono andate a buon fine<br>controlla i dati inseriti!");
			request.getRequestDispatcher("/modificautente.jsp").include(request, response);
		}
	}

}
