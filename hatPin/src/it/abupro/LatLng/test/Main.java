package it.abupro.LatLng.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import it.abupro.LatLng.entities.Pin;
import it.abupro.LatLng.function.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
/* ---------- era una prova per estrarre i dati pin immagazzinati su DB ------------ 
		PinHelper pH = new PinHelper();
		List<String> param4Marker = new LinkedList<String>();
		
		param4Marker = pH.importPinFields(); 
		
		//cicla e restituisce i singoli elementi del costruttore come singole stringhe
		//al momento le stampa a console ma bisogna integrarle con HTML per refresh!
		for (int i = 0; i < param4Marker.size(); i = i+3) {
			System.out.println(param4Marker.get(i).toString());
			System.out.println(param4Marker.get(i+1).toString());
			System.out.println(param4Marker.get(i+2).toString());
		}
------------------------------------OK-----------------------------------------*/
		
		
/*----------- test funzionamento metodo autenticazione utente -----------	
		UserHelper uH = new UserHelper();
		String usr = "red";
		String psw = "pswpsw";
		
		uH.checkUP(usr, psw);
		
		
	
-------------------------------------OK-----------------------------------*/
		
/*----------- test funzionamento metodo controllo dato unico -----------	
		UserHelper uH = new UserHelper();
		String usr = "ciccio"; //inputToCheck 1
		String email = "prova@prova.com"; //inputToCheck 2
		
		boolean AEUsr = uH.alredyExist("username", usr);
		if (AEUsr == true) {
			System.out.println("username già in uso");
		} else {
			System.out.println("username disponibile");
		}
		
		boolean AEEmail = uH.alredyExist("email", email);
		if (AEEmail == true) {
			System.out.println("email già in uso");
		} else {
			System.out.println("email disponibile");
		}
	
-------------------------------------OK-----------------------------------*/

		
/*----------- test funzionamento crea nuovo file in dir -----------	
		String path = "WebContent/PinPictures";
		
		try {
			OutputStream out = new FileOutputStream(new File(path+"/"+"prova.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
-------------------------------------OK-----------------------------------*/
		
/*----------- test funzionamento crea nuovo file in dir -----------	*/
//		InputStream fileIn = null;
//		FileOutputStream fileOut = null;
//		
//		try {
//		fileIn = new FileInputStream("C:\\Users\\ggcol\\Desktop\\dragonOnPinnacle.jpg");
//		fileOut = new FileOutputStream("C:\\Users\\ggcol\\git\\hatPin\\hatPin\\WebContent\\PinPictures\\dragonOnPinnacle.jpg");
//		
//		byte[] buffer = new byte[4096];
//		int byteLetti;
//		
//		while((byteLetti = fileIn.read(buffer)) >= 0) {
//			fileOut.write(buffer, 0, byteLetti);
//		}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (fileIn != null) fileIn.close();
//			if (fileOut != null) fileOut.close();
//			
//		}
		
		/*---------------test psw 2-------------------------
		UserHelper uH = new UserHelper();
		String psw1 = "prova2cb";
		String psw2 = "prova2cb";
		
		System.out.println(uH.checkPassword(psw1, psw2));
		------------------------------------------------ */
		
	}
}
