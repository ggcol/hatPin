package it.abupro.LatLng.test;

import java.util.LinkedList;
import java.util.List;

import it.abupro.LatLng.entities.Pin;
import it.abupro.LatLng.function.*;

public class Main {

	public static void main(String[] args) {
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
---------------------------------------------------------------------------------*/
		
		
/*----------- test funzionamento metodo autenticazione utente -----------	
		UserHelper uH = new UserHelper();
		String usr = "red";
		String psw = "pswpsw";
		
		uH.checkUP(usr, psw);
		
		
	
---------------------------------------------------------------------------*/
		
/*----------- test funzionamento metodo controllo dato unico -----------	
		UserHelper uH = new UserHelper();
		String usr = "ciccio"; //inputToCheck 1
		String email = "colombo.g@yandex.com"; //inputToCheck 2
		
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
	
---------------------------------------------------------------------------*/
		
		
	}
}
