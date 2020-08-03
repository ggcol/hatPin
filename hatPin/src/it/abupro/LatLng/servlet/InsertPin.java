package it.abupro.LatLng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.abupro.LatLng.entities.*;
import it.abupro.LatLng.function.PinHelper;

/**
 * Servlet implementation class InsertPin
 */
@WebServlet(name = "/insertPin", urlPatterns = {"/insertPin"})
@MultipartConfig //annotation per upload img
public class InsertPin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Pin p1 = new Pin();
		PinHelper pH = new PinHelper();

		p1.setTitle(request.getParameter("title"));
		p1.setBody(request.getParameter("body"));
		p1.setLatlng(request.getParameter("latlng"));
		//prende in parti il file
		Part img = request.getPart("file");
		//carica immagine e restituisce percorso assoluto come stringa
		//vedi PinHelper.java / uploadImg()
		String ref_img = pH.uploadImg(img);
		p1.setUsername(request.getParameter("username"));

		p1.setRef_img(ref_img);
		pH.newPin(p1);

		response.sendRedirect("dashboardhatpin.jsp");



	}	
}
