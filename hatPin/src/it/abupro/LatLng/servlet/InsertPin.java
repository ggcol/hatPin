package it.abupro.LatLng.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

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
@WebServlet("/insertPin")
@MultipartConfig //annotation per upload img
public class InsertPin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pin p1 = new Pin();
		PinHelper pH = new PinHelper();
		
		p1.setTitle(request.getParameter("titolo"));
		p1.setBody(request.getParameter("corpo"));
		p1.setLatlng(request.getParameter("latlng"));
		
		/* TROVARE MODO PER INSERIRE IMG 
		 * una base per idee:
		 * https://www.it-swarm.dev/it/java/come-caricare-file-sul-server-usando-jspservlet/968056424/
		 * */
		Part filePart = request.getPart("file");
		String ref_img = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		
		
		//salva PIN su DB
		//vedi PinHelper.java / newPin()
		pH.newPin(p1);
		
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
